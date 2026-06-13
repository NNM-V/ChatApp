/**
 * 
 */
var socket = new SockJS('chat');
var stompClient = Stomp.over(socket);
var sessionId = "";

function connectBtn() {
	stompClient.connect({}, function(){
		stompClient.subscribe('user/queue/specific-user', function (msgOut) {
			console.log(msgOut.body)
		});
	});
}

function sendBtn(){
	const msg = document.getElementById("send").value;
	stompClient.send('app/hello',{}, msg);
}

function disconnectBtn() {
	if (stompClient !== null) {
		stompClient.disconnect();
		stompClient = null;
	}
	console.log("Disconnected");
}