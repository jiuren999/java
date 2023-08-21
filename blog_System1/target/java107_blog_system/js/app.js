function getLoginStatus() {
    $.ajax({
        type: 'get',
        url: 'login',
        success: function(body) {
            // 响应 200 的时候, 执行 success 回调.
            console.log("用户已经登录了. ");
            // 把返回的用户名, 设置到页面中.
            let h3 = document.querySelector('.card h3');
            // body 已经是一个 js 对象了. 就是前面服务器返回的 json 格式的 user 对象.
            h3.innerHTML = body.username;
        },
        error: function(body) {
            // 响应 403 的时候, 执行 error 回调.  (只要返回不是 2 开头的, 都会触发 error)
            // 跳转到 login.html 主页.
            location.assign("login.html");
        }
    })
}
