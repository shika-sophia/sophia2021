<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadFile</title>
</head>
<body>
<!-- upload file form -->
<form action="UploadServlet"
      enctype="multipart/form-data" method="POST" >
  <input type="file" name="upFile" size="50" /><br />
  <input type="submit" value="Upload" />
</form>

</body>
</html>