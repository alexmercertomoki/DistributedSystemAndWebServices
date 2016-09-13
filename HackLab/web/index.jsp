
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
    <head>
        <title>Distributed Systems HackLab</title>

        <!-- Meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        
    </head> 

    <body>

        <div class="margin-bottom-40">
            <div class="container">
                <h1 class="pull-left">Distributed Systems HackLab</h1>                
            </div>
        </div>

        <!--=== Content Part ===-->
        <div class="container">
            <div class="row">


                <!--Begin Content-->
                <div class="col-md-12">

                    <div class="panel panel-blue margin-bottom-40">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="icon-tasks"></i>Enter your login details</h3>
                        </div>
                        <div class="panel-body">   

                            <%
                                if (request.getAttribute("error") != null) {
                            %>

                            <div class="alert alert-danger">
                                <%= request.getAttribute("error")%>
                            </div>

                            <%
                                }
                            %>


                            <form class="margin-bottom-40" role="form" method="POST" action="HackLab">
                                <div class="form-group">
                                    <input type="text" class="input-lg" name="username" placeholder="Username">
                                </div>
                                
                                <div class="form-group">
                                    <input type="password" class="input-lg" name="password" placeholder="Password">
                                </div>

                  

                                <input type="submit" value="Login" class="btn btn-primary"/>
                            </form>
                        </div>
                    </div>


                </div>
                <!--End Content-->
            </div>          
        </div><!--/container-->     
        <!--=== End Content Part ===-->

    </body>
</html> 