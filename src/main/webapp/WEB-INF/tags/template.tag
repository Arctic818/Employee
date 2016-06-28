<%@ tag description="template tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
    <head>

        <style>

            .main_body {
                background-color: #60bdff;
                margin: auto;
                width: 15%;
            }

            .title_body{
                text-align: center;
                color: #ffffff;
                font-size: 200%;
            }

            td, th {
                padding: 10px;
            }

            .book-list-table, .book-list-table td, .book-list-table th {
                width: 100%;
                border: 1px solid black;
                border-collapse: collapse;
            }

            #button_main1, #button_main2, #button_main3, #button_main4 {
                width: 100%;
                text-align: center;

                background-color: #ccc;

                border-radius:6px;
                color: rgba(0, 0, 0, 0.99);

                font-size: 20px;
                text-decoration: none;
                cursor: pointer;
                border:black;
            }

            #button_main1:hover,#button_main2:hover,#button_main3:hover, #button_main4:hover {
                background-color: #6de9ff;
            }


        </style>

        <script>
            function _DeleteDepartment(){
                this.deleteDepartment = function(id) {
                    if (confirm("Are you sure?")){
                        window.location = "/DeleteDepartment/?id=" + id;
                    }
                }
            }

            var DeleteDepartment = new _DeleteDepartment;
        </script>


        <title>Employee manager</title>

    </head>

    <body>
        <div class="main_body">
            <div class="title_body">Employees manager</div><br>


            <jsp:doBody/>

        </div>
    </body>
</html>