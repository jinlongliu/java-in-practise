<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2016/11/7
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCYPTE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        /*总大小，已上传大小，总个数，已上传个数*/
        var totalFileLength, totalUploaded, fileCount, filesUploaded;

        /*调试信息输出函数*/
        function debug(s) {
            var debug = document.getElementById('debug');
            if (debug) {
                debug.innerHTML = debug.innerHTML + '<br/>' + s;
            }
        }

        function onUploadComplete(e) {
            /*完成上传，计算已上传大小、个数*/
            totalUploaded += document.getElementById('files').files[filesUploaded].size;
            filesUploaded++;
            debug('complete ' + filesUploaded + ' of' + fileCount);
            debug('totalUploaded: ' + totalUploaded);
            if (filesUploaded < fileCount ) {
                uploadNext();
            } else {
                var bar = document.getElementById('bar');
                bar.style.width = '100%';
                bar.innerHTML = '100% complete';
                alert('Finished uploading file(s)');
            }
        }

        function onFileSelect(e) {
            /*输出已选文件和总大小*/
            var files = e.target.files;
            var output = [];
            fileCount = files.length;
            totalFileLength = 0;
            for (var i = 0; i<fileCount; i++) {
                output.push(file.name, ' (',
                        file.size, ' bytes, ',
                        file.lastModifiedDate.toLocaleDateString(), ')');
                output.push('<br/>');
                debug('add ' + file.size);
                totalFileLength += file.size;
            }
            document.getElementById('selectedFiles').innerHTML =
                    out.join('');
            debug('totalFileLength:' + totalFileLength);
        }

        function onUploadProgress(e) {
            /*计算上传比例显示进度条*/
            if (e.lengthComputable) {
                var percentComplete = parseInt(
                        (e.loaded + totalUploaded) * 100 / totalFileLength);
                var bar = document.getElementById('bar');
                bar.style.width = percentComplete + '%';
                bar.innerHTML = percentComplete + ' % complete';
            } else {
                debug('unable to compute')
            }
        }

        function onUploadFailed(e) {
            alert("Error uploading file");
        }

        function uploadNext() {
            /*上传下一个文件并把事件对应到函数*/
            var xhr = new XMLHttpRequest();
            var fd = new FormData();
            var file = document.getElementById('files').
                    files[filesUploaded];
            fd.append("multipartFile", file);
            xhr.upload.addEventListener("progress", onUploadProgress, false);
            xhr.addEventListener("load", onUploadComplete, false);
            xhr.addEventListener("error", onUploadFailed, false);
            xhr.open("POST", "file_upload");
            debug("uploading" + file.name);
            xhr.send(fd);
        }

        function startUpload() {
            totalUploaded = filesUploaded = 0;
            uploadNext();
        }

        /*窗口完全下载后运行window.onload*/
        window.onload = function () {
            document.getElementById('files').addEventListener(
                    'change', onFileSelect, false);
            document.getElementById('uploadButton').addEventListener(
                    'click', startUpload, false);
        }
    </script>
    <title>文件上传</title>
</head>
<body>
<h1>多文件上传附带进度条</h1>
<div id="progressBar" style="height:20px;border:2px solid green">
    <div id="bar" style="height: 100%;background: #33dd33;width: 0%">

    </div>
</div>
<form>
    <input type="file" id="files" multiple/>
    <br/>
    <output id="selectedFiles"></output>
    <input id="uploadButton" type="button" value="Upload"/>
</form>
<div id="debug" style="height: 100px;border: 2px solid green;overflow: auto">
</div>
</body>
</html>
