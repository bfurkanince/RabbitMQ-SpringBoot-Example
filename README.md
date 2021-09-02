İnstall and Run RabbitMq Server :
  Brew must installed on mac , 
  brew update run command on terminal , 
  brew install rabbitmq run command on terminal ,
  run server command -> /opt/homebrew/opt/rabbitmq/sbin/rabbitmq-server ,
  Open browser and enter http://localhost:15672/ to redirect to RabbitMq Dashboard ,
  Login page username and password is guest ,
  After succesfully login you should see RabbitMQ Home Page ,
  
  How to Run :
    Open Postman and enter to url http://localhost:9292/order/kfc and change method to POST and below json copy to raw then clict to Send button ,
    
    {
      "name":"hamburger13",
      "quantity":"1",
      "price":"45"
    }
    
    


