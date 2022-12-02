var wsURI = "ws://" + document.location.host + document.location.pathname + "chat";

var websocket = new SockJS(wsURI);

websocket.onmessage = function(evnt)
{
    onMessage(evnt);
};

websocket.onopen = function()
{
    onOpen();
};

function onOpen()
{
    console.log("Opened connection: " + wsURI);
}

function onClose()
{
    console.log("Closed connection: " + wsURI);
}

function onMessage(event)
{
    console.log(event);
    display(event.data);
}

function display(message)
{
    document.getElementById("output").innerHTML += message + "</br>";
}

function send()
{
    var message = document.getElementById("message_input").value;
    console.log("Sending: " + message);
    websocket.send(message);
}