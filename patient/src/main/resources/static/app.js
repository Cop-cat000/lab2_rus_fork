let stompClient = null;

document.getElementById('connect').addEventListener('click', () => {
    console.log("Connecting to WebSocket...");
    const socket = new SockJS('/api/patients/broker'); // Убедись, что этот путь совпадает с серверной конфигурацией
    stompClient = Stomp.over(socket);

    stompClient.connect({}, (frame) => {
        console.log("Connected: " + frame);
        document.getElementById('connect').disabled = true;
        document.getElementById('disconnect').disabled = false;

        // Подписка на сообщения
        stompClient.subscribe('/api/patients/topic/created', (message) => {
            const receivedData = JSON.parse(message.body);
            const messagesList = document.getElementById('messages');
            const listItem = document.createElement('li');
            listItem.textContent = `Name: ${receivedData.name}, Date of Birth: ${receivedData.dateOfBirth}, Email: ${receivedData.email}`;
            // Добавляем новое сообщение в начало списка
            messagesList.insertBefore(listItem, messagesList.firstChild);
        });
    }, (error) => {
        console.error("Error connecting to WebSocket:", error);
    });
});

document.getElementById('disconnect').addEventListener('click', () => {
    if (stompClient) {
        stompClient.disconnect(() => {
            console.log("Disconnected");
            document.getElementById('connect').disabled = false;
            document.getElementById('disconnect').disabled = true;
        });
    }
});

document.getElementById('send-form').addEventListener('submit', (event) => {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const dateOfBirth = document.getElementById('dateOfBirth').value;
    const email = document.getElementById('email').value;

    const dto = {
        name: name,
        dateOfBirth: dateOfBirth,
        email: email
    };

    if (stompClient && stompClient.connected) {
        stompClient.send('/api/patients/ws/create', {}, JSON.stringify(dto));
        console.log('Sent:', dto);
    } else {
        console.error("WebSocket is not connected. Cannot send message.");
    }
});