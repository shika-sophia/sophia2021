package webPractice.uploadFile;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location="src/webPractice/uploadFile")
@WebServlet("/webPractice/uploadFile/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }//doGet()

    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //UploadFileの取得
        Part part = request.getPart("upFile");

        //元のファイル名を取得し保存
        String originName = this.getOriginName(part);

        if(this.isValidFile(originName)) {
            part.write(
                this.getServletContext().getRealPath("/WEB-INF/data") +
                "/" + originName
            );

            response.sendRedirect("uploadFile/uploadFile.jsp");
        } else {
            response.getWriter().println("<!> Invalid file can't be uploaded.");
        }
    }//doPost()

    private String getOriginName(Part part) {
        String result = null;
        String headerDisp = part.getHeader("Content-Disposition");
        String[] dispAry = headerDisp.split(";");

        for(String disp : dispAry) {
            disp = disp.trim();
            if(disp.startsWith("filename")) {
                result = disp.substring(disp.indexOf("=") + 1).trim();
                result = result.replace("\"", "").replace("\\", "/");
                int pos = result.lastIndexOf("/");

                if(pos >= 0) {
                    result = result.substring(pos + 1);
                }

                break;
            }//if
        }//for

        return result;
    }//getOriginName()

    private final boolean isValidFile(String originName) {
        final String[] allowed = {"jpg","jpeg","gif","png"};

        if(originName != null) {
            String[] nameAry = originName.split("\\.");
            String fileType = nameAry[nameAry.length - 1];

            boolean valid =
                Stream.of(allowed)
                    .anyMatch(a -> a.equalsIgnoreCase(fileType));

            return valid;
        }

        return false;
    }//isValidFile()
}//class

/*
【参考】 文字列加工の経過
Content-Disposition: form-data; name="file"; filename="C:\data\wings.jpg";

＊String headerDisp = part.getHeader("Content-Disposition");
    「 form-data; name="file"; filename="C:\data\wings.jpg";」

＊String[] dispAry = headerDisp.split(";");
    {" form-data", " name=\"file\"", " filename=\"C:\data\wings.jpg\""}
＊disp.trim();
    {"form-data", "name=\"file\"", "filename=\"C:\data\wings.jpg\""}

＊if(disp.startsWith("filename"));
    「filename=\"C:\data\wings.jpg\"」

＊String result = disp.substring(disp.indexOf("=") + 1).trim();
    「\"C:\\data\\wings.jpg\"」

＊result = result.replace("\"", "").replace("\\", "/");
    「C:/data/wings.jpg」

＊result = result.substring(result.lastIndexOf("/"));
    「wings.jpg」
*/