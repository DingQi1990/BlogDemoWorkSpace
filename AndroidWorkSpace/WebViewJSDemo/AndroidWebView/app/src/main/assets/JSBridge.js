function beStronger(value) {
    let box = document.getElementById("box");
    // box.innerText = value;
    box.className = "box2";
    box.innerText=value;
    return "小明你好"
}


function sendMsg() {
    Android_Interface.sendMsg("你好,这是要传递的参数")
}
