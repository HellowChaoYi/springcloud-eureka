layui.use(['element', 'layer', 'form', 'table'], function() {
    var element = layui.element,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    const mock = { "code": 0, "msg": "", "count": 1000, "data": [{ "id": 10010, "username": "user-9", "sex": "女", "city": "城市-10", "sign": "签名-10", "experience": 1016, "logins": 182, "wealth": 71294671, "classify": "诗人", "score": 34 }, { "id": 10011, "username": "user-11", "sex": "女", "city": "城市-11", "sign": "签名-11", "experience": 492, "logins": 107, "wealth": 8062783, "classify": "诗人", "score": 6 }, { "id": 10012, "username": "user-12", "sex": "女", "city": "城市-12", "sign": "签名-12", "experience": 106, "logins": 176, "wealth": 42622704, "classify": "词人", "score": 54 }, { "id": 10013, "username": "user-13", "sex": "男", "city": "城市-13", "sign": "签名-13", "experience": 1047, "logins": 94, "wealth": 59508583, "classify": "诗人", "score": 63 }, { "id": 10014, "username": "user-14", "sex": "男", "city": "城市-14", "sign": "签名-14", "experience": 873, "logins": 116, "wealth": 72549912, "classify": "词人", "score": 8 }, { "id": 10015, "username": "user-15", "sex": "女", "city": "城市-15", "sign": "签名-15", "experience": 1068, "logins": 27, "wealth": 52737025, "classify": "作家", "score": 28 }, { "id": 10016, "username": "user-16", "sex": "女", "city": "城市-16", "sign": "签名-16", "experience": 862, "logins": 168, "wealth": 37069775, "classify": "酱油", "score": 86 }, { "id": 10017, "username": "user-17", "sex": "女", "city": "城市-17", "sign": "签名-17", "experience": 1060, "logins": 187, "wealth": 66099525, "classify": "作家", "score": 69 }, { "id": 10018, "username": "user-18", "sex": "女", "city": "城市-18", "sign": "签名-18", "experience": 866, "logins": 88, "wealth": 81722326, "classify": "词人", "score": 74 }, { "id": 10019, "username": "user-19", "sex": "女", "city": "城市-19", "sign": "签名-19", "experience": 682, "logins": 106, "wealth": 68647362, "classify": "词人", "score": 51 }] };
	
    
    /* 面包屑切换 */
    const breadCrumb = document.querySelector('.layui-breadcrumb');
    document.querySelector('.layui-nav-tree').addEventListener('click', (e) => {
        const target = e.target,
            curTarget = e.currentTarget;
        console.log('click target', target.nodeName.toLocaleLowerCase());
        if (target.nodeName.toLocaleLowerCase() == 'a' && hasClass(target, 'this_nav')) {
            //渲染
            document.querySelector('#main_contain').innerHTML = target.innerText;
            if (document.querySelector('#main_contain').innerHTML == '通用参数设置') {
                let tableBox = document.createElement('div');
                tableBox.id = 'demo';
                tableBox.setAttribute('lay-filter', 'demo');
                document.querySelector('#main_contain').appendChild(tableBox);
                table.render({
                    elem: '#demo',
                    url: 'http://localhost:8095/server/db/getyml',
                    toolbar: '#toolbarDemo',
                    page: false,
                    cols: [
                        [
                            { field: 'driver_class_name', title: '数据库连接池', sort: true, fixed: 'left' },
                            { field: 'url', title: '数据库地址' },
                            { field: 'username', title: '用户名', sort: true },
                            { field: 'password', title: '密码', },
                            { fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150 }
                        ]
                    ]
                });
            }

            let breadArr = [];
            breadArr.push(target.getAttribute('data-name'));
            let parentNodes = target;
            do {
                parentNodes = parentNodes.parentNode;
                if (parentNodes.getAttribute('data-name')) {
                    breadArr.push(parentNodes.getAttribute('data-name'));
                }
            } while (!hasClass(parentNodes, 'topest'));

            let breadHtml = '<a href="">首页</a>';
            for (let i = breadArr.length - 1; i >= 0; i--) {
                if (i == 0) {
                    breadHtml += `<a><cite>${breadArr[i]}</cite></a>`;
                } else {
                    breadHtml += `<a>${breadArr[i]}</a>`;
                }
            }
            breadCrumb.innerHTML = breadHtml;
            element.render();
        }
    })

    //头工具栏事件
    table.on('toolbar(demo)', function(obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
        };
    });

    //监听行工具事件
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function(index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.prompt({
                formType: 2,
                value: data.email
            }, function(value, index) {
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });

    /* 点击面包屑 */
    document.querySelector('.layui-breadcrumb').addEventListener('click', function(e) {
        const t = e.target.innerText;
        if (t !== '首页') {
            debugger
            document.querySelector(`.this_nav[data-name=${t}]`).click();
        }
    })

    /*  收起导航 */
    document.querySelector('.switch-nav-status').addEventListener('click', function() {
        const body = document.querySelector('body');
        if (hasClass(body, 'mini-sidebar')) {
            body.classList.remove("mini-sidebar");
            this.classList.add('layui-icon-shrink-right');
            this.classList.remove('layui-icon-spread-left');
            document.querySelector('.search-box').classList.remove('mini');
        } else {
            body.classList.add("mini-sidebar");
            this.classList.add('layui-icon-spread-left');
            this.classList.remove('layui-icon-shrink-right');
            document.querySelector('.search-box').classList.add('mini');
            document.querySelector('.search-input').value = '';
            document.querySelector('.search-input').blur();
        }
        element.render();
    })

    /* 搜索框hover */
    document.querySelector('.search-input').addEventListener('mouseover', function(e) {
        const body = document.querySelector('body');
        if (hasClass(body, 'mini-sidebar')) {
            document.querySelector('.search-box').classList.remove('mini');
        }
    })

    document.querySelector('.search-box').addEventListener('mouseout', function(e) {
        const body = document.querySelector('body');
        if (hasClass(body, 'mini-sidebar')) {
            e.currentTarget.classList.add('mini');
            document.querySelector('.search-input').value = '';
            document.querySelector('.search-input').blur();
        }
    })

    /* 退出 */
    document.querySelector('#logout').onclick = function() {
        window.location.href = 'login.html';
    }

    function fullScreen() {
        var el = document.documentElement;
        var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullscreen;
        if (typeof rfs != "undefined" && rfs) {
            rfs.call(el);
        };
        return;
    }

    /* 全屏 */
    document.querySelector('#full-screen').onclick = function() {
        fullScreen();
    }

    /* 刷新 */
    document.querySelector('#refresh').onclick = function() {
        window.location.reload();
    }
});