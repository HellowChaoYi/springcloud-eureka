/* 
=========================
    ◥◤~~~~◥◤　　
    ┃　　　　┃
    ≡━ ﹏ ━≡　　
    ┗━━┳∞┳━━┛ 
    　┏┫　┣┓
    
    rain常用方法封装
    原生，没有依赖
    也有一些jq的方法，那就依赖jq咯，反正看着办咯
    啦啦啦~~~~~~~~

    ("\ (●–●)
    \ / O \  \ Hello! I am Baymax, your personal healthcare companion.^_^
     (       )
     \__T __/
=========================	
 */

/* 
	设置页面rem 
 */
/* (function(doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function() {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            let elWid = clientWidth > 1024 ? clientWidth : 720;
            docEl.style.fontSize = 100 * (clientWidth / elWid) + 'px';
        };
    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window); */

/**
 * 判断用户访问的是pc还是mobile或者微信浏览器
 */
var browser = {
        versions: function() {
            var u = navigator.userAgent.toLowerCase();
            return {
                trident: u.indexOf('trident') > -1,
                presto: u.indexOf('presto') > -1,
                isChrome: u.indexOf("chrome") > -1 && u.indexOf("safari") > -1 && !(u.indexOf("qqbrowser") > -1),
                qqbrowser: u.indexOf("qqbrowser") > -1,
                isFirefox: u.indexOf('firefox') > -1,
                isSafari: !(u.indexOf("chrome") > -1) && (/webkit|khtml/).test(u) && u.indexOf('safari') > -1,
                webKit: u.indexOf('applewebkit') > -1,
                gecko: u.indexOf('gecko') > -1 && u.indexOf('khtml') == -1,
                mobile: !!u.match(/applewebkit.*mobile.*/),
                ios: !!u.match(/\(i[^;]+;( u;)? cpu.+mac os x/),
                android: u.indexOf('android') > -1 || u.indexOf('linux') > -1,
                iPhone: u.indexOf('iphone') > -1,
                iPad: u.indexOf('ipad') > -1,
                iWinPhone: u.indexOf('windows phone') > -1,
                isWeiXin: !!u.match(/MicroMessenger/i)
            }
        }
    }
    /* if (browser.versions.mobile || browser.versions.iWinPhone) {
        console.log('手机');
    } else {
        console.log('pc');
    } */

/**
 * 判断浏览器
 */
function getInternet() {
    if (navigator.userAgent.indexOf("MSIE") > 0) {
        return "MSIE"; //IE浏览器  
    }
    if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
        return "Firefox"; //Firefox浏览器  
    }
    if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
        return "Safari"; //Safan浏览器  
    }
    if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
        return "Camino"; //Camino浏览器  
    }
    if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
        return "Gecko"; //Gecko浏览器  
    }
}

/**
 * 阻止冒泡
 * @param {ele} e 
 */
function stopPro(e) {
    e = e || window.event;
    window.event ? e.cancelBubble = true : e.stopPropagation();
}

/**
 * 保留两位小数并每三位加逗号
 * @param {需要转化的小数} data 
 */
function number(data) {
    if (data != null) {
        return data.toFixed(2).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
    } else {
        return;
    }
}

/**
 * 获取自定义属性
 * @param {获取dom} e 
 * @param {属性名, 不加data-} name 
 */
function getDataset(e, name) {
    return e.dataset[name] || e.getAttribute('data-' + name);
}

/**
 * 设置自定义属性
 * @param {dom} e 
 * @param {属性名，data-name} name 
 * @param {值} val 
 * @return {e} 
 */
function setDataset(e, name, val) {
    e.setAttribute(name, val);
    return e;
}

/**
 * 原生ajax
 */
var Ajax = {
    get: function(url, successFn, errorFn, callback) {
        // XMLHttpRequest对象用于在后台与服务器交换数据   
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {
                successFn.call(this, xhr.responseText);
            } else {
                if (errorFn) {
                    errorFn.call(this, xhr.responseText);
                }
            }
        };
        if (callback) {
            callback.call(this, xhr);
        }
        xhr.send();
    },
    // datat应为'a=a1&b=b1'这种字符串格式
    post: function(url, data, type, successFn, errorFn, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        // 添加http头，发送信息至服务器时内容编码类型
        if (type == "formdata") {
            /* data = new FormData();
            data.append("key", "value"); */
        } else if (type == "json") {
            xhr.setRequestHeader("Content-Type", "application/json");
            /* data = JSON.stringify({ "key": "value" }); */
        } else if (type == "text") {
            /* data = "key=value"; */
        } else if (type == "www") {
            // 这个header 其实是 传统post 表单的格式
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            /* data = "key=value&key=value"; */
        }
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {
                successFn.call(this, xhr.responseText);
            } else {
                if (errorFn) {
                    errorFn.call(this, xhr.responseText);
                }
            }
        };
        if (callback) {
            callback.call(this, xhr);
        }
        xhr.send(data);
    }
}

/**
 * 查找祖先元素
 * @param {String} pClassName -要查找的祖先元素的classname
 * @param {Object} ele =当前元素
 * @return {Object}
 */
function findpNode(pClassName, ele) {
    e = ele.parentNode;

    if (e.nodeName.toLowerCase() == 'body') {
        return false;
    }

    var clsName = e.className.split(' '),
        pClsName = pClassName.split(' ');

    //求交集，如果交集的数量等于需要匹配(pClsName)的数量，则完全匹配
    var intersect = clsName.filter(function(x) {
        return pClsName.indexOf(x) !== -1
    });

    if (intersect.length != pClsName.length) {
        return findpNode(pClassName, e);
    }

    return e;
}

/**
 * 是否有指定class
 * @param {Object} e
 * @param {String} clsName 
 */
function hasClass(e, clsName) {
    var clsList = e.className.split(' ');
    if (clsList.indexOf(clsName) != -1) {
        return true;
    }
    return false;
}

/**
 * 时间戳转日期，格式XXXX-XX-XX XX:XX:XX
 * @param {Number} timestamp 
 */
function timestampToTime(timestamp) {
    var date = new Date(parseInt(timestamp)),
        Y = date.getFullYear() + '-',
        M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-',
        D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()) + ' ',
        h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':',
        m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':',
        s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()) + '';
    return Y + M + D + h + m + s;
}

/**
 * 时间戳转日期，格式XXXX-XX-XX
 * @param {Number} timestamp 
 */
function timestampToDay(timestamp) {
    var date = new Date(parseInt(timestamp)),
        Y = date.getFullYear() + '-',
        M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-',
        D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate());
    return Y + M + D;
}

/**
 * 日期转时间戳，精确到毫秒
 * @param {String} time 
 */
function timeToTimestamp(time) {
    var date = new Date(time);
    return date.getTime()
}

/**
 * 秒转时间
 * @param {Number} s -时间戳（单位：秒）
 */
function secToTime(s) {
    var t;
    if (s > -1) {
        var hour = Math.floor(s / 3600);
        var min = Math.floor(s / 60) % 60;
        var sec = s % 60;
        if (hour < 10) {
            t = '0' + hour + ":";
        } else {
            t = hour + ":";
        }

        if (min < 10) { t += "0"; }
        t += min + ":";
        if (sec < 10) { t += "0"; }
        t += sec.toFixed(2);
    }
    return t;
}


/**
 * 时间转秒
 * @param {String} time -时分秒 00:00:00
 */
function timeToSec(time) {
    var s = '';

    var hour = time.split(':')[0];
    var min = time.split(':')[1];
    var sec = time.split(':')[2];

    s = Number(hour * 3600) + Number(min * 60) + Number(sec);

    return s;
};

/**
 * 滚动高度
 */
function getScrollTop() {
    var scrollTop = 0,
        bodyScrollTop = 0,
        documentScrollTop = 0;
    if (document.body) {
        bodyScrollTop = document.body.scrollTop;
    }
    if (document.documentElement) {
        documentScrollTop = document.documentElement.scrollTop;
    }
    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
    return scrollTop;
}

/**
 * 文档的总高度
 */
function getScrollHeight() {
    var scrollHeight = 0,
        bodyScrollHeight = 0,
        documentScrollHeight = 0;
    if (document.body) {
        bodyScrollHeight = document.body.scrollHeight;
    }
    if (document.documentElement) {
        documentScrollHeight = document.documentElement.scrollHeight;
    }
    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
    return scrollHeight;
}

/**
 * 视口高度
 */
function getWindowHeight() {
    var windowHeight = 0;
    if (document.compatMode == "CSS1Compat") {
        windowHeight = document.documentElement.clientHeight;
    } else {
        windowHeight = document.body.clientHeight;
    }
    return windowHeight;
}

/**
 * 获取XX天过去日期
 * @param {Number} day -过去多少天的
 */
function getDay(day) {
    function doHandleMonth(month) {
        var m = month;
        if (month.toString().length == 1) {
            m = "0" + month;
        }
        return m;
    }

    var today = new Date();

    var targetday_milliseconds = today.getTime() + 1000 * 60 * 60 * 24 * day;

    today.setTime(targetday_milliseconds);

    var tYear = today.getFullYear();
    var tMonth = today.getMonth();
    var tDate = today.getDate();
    tMonth = doHandleMonth(tMonth + 1);
    tDate = doHandleMonth(tDate);
    return tYear + '/' + tMonth + '/' + tDate;
}

/**
 * 获取当月第一天
 * 返回时间戳
 */
function getCurrentMonthFirst() {
    var date = new Date().setDate(1)

    //上面的时间戳转日期 xxxx-xx-xx
    return timestampToDay(date);
}

/**
 * 获取当月最后一天
 * 返回时间戳
 */
function getCurrentMonthLast() {
    var date = new Date();
    var currentMonth = date.getMonth();
    var nextMonth = ++currentMonth;
    var nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
    var oneDay = 1000 * 60 * 60 * 24;
    return nextMonthFirstDay - oneDay;
}

/**
 * 获取当前日期农历
 */
function getLunarCalendar() {
    var CalendarData = new Array(100);
    var madd = new Array(12);
    var tgString = "甲乙丙丁戊己庚辛壬癸";
    var dzString = "子丑寅卯辰巳午未申酉戌亥";
    var numString = "一二三四五六七八九十";
    var monString = "正二三四五六七八九十冬腊";
    var weekString = "日一二三四五六";
    var sx = "鼠牛虎兔龙蛇马羊猴鸡狗猪";
    var cYear, cMonth, cDay, TheDate;
    CalendarData = new Array(0xA4B, 0x5164B, 0x6A5, 0x6D4, 0x415B5, 0x2B6, 0x957, 0x2092F, 0x497, 0x60C96, 0xD4A, 0xEA5, 0x50DA9, 0x5AD, 0x2B6, 0x3126E, 0x92E, 0x7192D, 0xC95, 0xD4A, 0x61B4A, 0xB55, 0x56A, 0x4155B, 0x25D, 0x92D, 0x2192B, 0xA95, 0x71695, 0x6CA, 0xB55, 0x50AB5, 0x4DA, 0xA5B, 0x30A57, 0x52B, 0x8152A, 0xE95, 0x6AA, 0x615AA, 0xAB5, 0x4B6, 0x414AE, 0xA57, 0x526, 0x31D26, 0xD95, 0x70B55, 0x56A, 0x96D, 0x5095D, 0x4AD, 0xA4D, 0x41A4D, 0xD25, 0x81AA5, 0xB54, 0xB6A, 0x612DA, 0x95B, 0x49B, 0x41497, 0xA4B, 0xA164B, 0x6A5, 0x6D4, 0x615B4, 0xAB6, 0x957, 0x5092F, 0x497, 0x64B, 0x30D4A, 0xEA5, 0x80D65, 0x5AC, 0xAB6, 0x5126D, 0x92E, 0xC96, 0x41A95, 0xD4A, 0xDA5, 0x20B55, 0x56A, 0x7155B, 0x25D, 0x92D, 0x5192B, 0xA95, 0xB4A, 0x416AA, 0xAD5, 0x90AB5, 0x4BA, 0xA5B, 0x60A57, 0x52B, 0xA93, 0x40E95);
    madd[0] = 0;
    madd[1] = 31;
    madd[2] = 59;
    madd[3] = 90;
    madd[4] = 120;
    madd[5] = 151;
    madd[6] = 181;
    madd[7] = 212;
    madd[8] = 243;
    madd[9] = 273;
    madd[10] = 304;
    madd[11] = 334;

    function GetBit(m, n) {
        return (m >> n) & 1;
    }

    function e2c() {
        TheDate = (arguments.length != 3) ? new Date() : new Date(arguments[0], arguments[1], arguments[2]);
        var total, m, n, k;
        var isEnd = false;
        var tmp = TheDate.getYear();
        if (tmp < 1900) {
            tmp += 1900;
        }
        total = (tmp - 1921) * 365 + Math.floor((tmp - 1921) / 4) + madd[TheDate.getMonth()] + TheDate.getDate() - 38;

        if (TheDate.getYear() % 4 == 0 && TheDate.getMonth() > 1) {
            total++;
        }
        for (m = 0;; m++) {
            k = (CalendarData[m] < 0xfff) ? 11 : 12;
            for (n = k; n >= 0; n--) {
                if (total <= 29 + GetBit(CalendarData[m], n)) {
                    isEnd = true;
                    break;
                }
                total = total - 29 - GetBit(CalendarData[m], n);
            }
            if (isEnd) break;
        }
        cYear = 1921 + m;
        cMonth = k - n + 1;
        cDay = total;
        if (k == 12) {
            if (cMonth == Math.floor(CalendarData[m] / 0x10000) + 1) {
                cMonth = 1 - cMonth;
            }
            if (cMonth > Math.floor(CalendarData[m] / 0x10000) + 1) {
                cMonth--;
            }
        }
    }

    function GetcDateString() {
        var tmp = "";
        tmp += tgString.charAt((cYear - 4) % 10);
        tmp += dzString.charAt((cYear - 4) % 12);
        tmp += "(";
        tmp += sx.charAt((cYear - 4) % 12);
        tmp += ")年 ";
        if (cMonth < 1) {
            tmp += "(闰)";
            tmp += monString.charAt(-cMonth - 1);
        } else {
            tmp += monString.charAt(cMonth - 1);
        }
        tmp += "月";
        tmp += (cDay < 11) ? "初" : ((cDay < 20) ? "十" : ((cDay < 30) ? "廿" : "三十"));
        if (cDay % 10 != 0 || cDay == 10) {
            tmp += numString.charAt((cDay - 1) % 10);
        }
        return tmp;
    }

    function GetLunarDay(solarYear, solarMonth, solarDay) {
        //solarYear = solarYear<1900?(1900+solarYear):solarYear;
        if (solarYear < 1921 || solarYear > 2020) {
            return "";
        } else {
            solarMonth = (parseInt(solarMonth) > 0) ? (solarMonth - 1) : 11;
            e2c(solarYear, solarMonth, solarDay);
            return GetcDateString();
        }
    }

    var D = new Date();
    var yy = D.getFullYear();
    var mm = D.getMonth() + 1;
    var dd = D.getDate();
    var ww = D.getDay();
    var ss = parseInt(D.getTime() / 1000);
    if (yy < 100) yy = "19" + yy;

    return GetLunarDay(yy, mm, dd);
}

/**
 * 获取星期几
 * @param {String} day 
 */
function getWeekDay(day) {
    var a = new Date(day);
    var myxingqi = a.getDay();
    var b;
    switch (myxingqi) {
        case 0:
            b = "星期日";
            break;
        case 1:
            b = "星期一";
            break;
        case 2:
            b = "星期二";
            break;
        case 3:
            b = "星期三";
            break;
        case 4:
            b = "星期四";
            break;
        case 5:
            b = "星期五";
            break;
        case 6:
            b = "星期六";
            break;
        default:
            b = "系统错误，无法读取日期！";
    }
    return b;
}

/**
 * 图片、视频预览
 * @param {Object} file 
 */
function onUpload(file) {
    var fr = new FileReader();
    fr.readAsDataURL(file); // 将文件读取为Data URL

    fr.onload = function(e) {
        var result = e.target.result;
        return result;
    }
}


/**
 * 密码可见与隐藏
 * @param {Object} el 
 * @param {Boolean} isShow 
 */
function switchPwd(el, isShow) {
    if (isShow) {
        //密码可见
        el.prop('type', 'text');
    } else {
        //密码不可见
        el.prop('type', 'password');
    }
}

/**
 * echart X轴限制字数，换行
 * @param {String} params -echart axisLabel 的 formatter的参数
 * @param {Number} number -每行能显示的字的个数
 */
function wrapXaxis(params, number) {
    var newParamsName = ""; // 最终拼接成的字符串
    var paramsNameNumber = params.length; // 实际标签的个数
    var provideNumber = number; // 每行能显示的字的个数
    var rowNumber = Math.ceil(paramsNameNumber / provideNumber); // 换行的话，需要显示几行，向上取整
    /* 判断标签的个数是否大于规定的个数， 如果大于，则进行换行处理 如果不大于，即等于或小于，就返回原标签 */
    // 条件等同于rowNumber>1
    if (paramsNameNumber > provideNumber) {
        /** 循环每一行,p表示行 */
        for (var p = 0; p < rowNumber; p++) {
            var tempStr = ""; // 表示每一次截取的字符串
            var start = p * provideNumber; // 开始截取的位置
            var end = start + provideNumber; // 结束截取的位置
            // 此处特殊处理最后一行的索引值
            if (p == rowNumber - 1) {
                // 最后一次不换行
                tempStr = params.substring(start, paramsNameNumber);
            } else {
                // 每一次拼接字符串并换行
                tempStr = params.substring(start, end) + "\n";
            }
            newParamsName += tempStr; // 最终拼成的字符串
        }
    } else {
        // 将旧标签的值赋给新标签
        newParamsName = params;
    }
    //将最终的字符串返回
    return newParamsName;
}

/**
 * promise jq ajax
 * @param {Object} option -配置
 */
function getAjaxPromise(option) {
    return new Promise(function(resolve, reject) {
        $.ajax({
            url: option.url,
            type: 'get',
            data: option.data || '',
            success: function(data) {
                resolve(data);
            },
            error: function(error) {
                reject(error);
            }
        });
    });
};

/*
//启动第1个异步任务
var p1 = getAjaxPromise({
url: '1'
});

p1.then(function(data1){
//处理第1个异步任务的结果
console.log(data1);

//然后启动第2个异步任务
return getAjaxPromise({
    url: '2'
});
})
.then(function(data2){
//处理第2个异步任务的结果
console.log(data2);
});
*/

/**
 * promise 原生ajax
 * @param {String} method -get/post
 * @param {String} url 
 * @param {Object} data 
 */
function ajax(method, url, data) {
    /*兼容IE*/
    var request;
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else {
        request = new ActiveXObject("Microsoft.XMLHTTP")
    }
    return new Promise(function(resolve, reject) {
        request.onreadystatechange = function() {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    resolve(JSON.parse(request.response));
                } else {
                    reject(request.status);
                }
            }
        };
        if (method.toUpperCase() === "GET") {
            var arr = [];
            for (var key in data) {
                arr.push(key + '=' + data[key]);
            }
            var getData = arr.join("&");

            request.open("GET", url + "?" + getData, true);
            request.send(null);
        } else if (method.toUpperCase() === "POST") {
            request.open("POST", url, true);
            request.responseType = "json";
            request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
            request.send(data);
        }
    });
};
/* var obj = {
access_token: '3452d32463e1b36ad94ee56931ea3cf0',
pageNumber: 1,
pageSize: 20
}
var url = 'https://denterpriseapi.coolcollege.cn/course/queryCourseByPage'
//开始调用接口
ajax('get', url, obj).then(function(data) {
console.log(data)
}).catch(function(err) {
console.log(err)
}) */

/**
 * 滚动到指定位置动画
 */


/**
 *判断浏览器内核
 */
function getBrowserInfo() {
    var ua = navigator.userAgent.toLocaleLowerCase();
    var browserType = null;
    if (ua.match(/msie/) != null || ua.match(/trident/) != null) {
        browserType = "IE";
        browserVersion = ua.match(/msie ([\d.]+)/) != null ? ua.match(/msie ([\d.]+)/)[1] : ua.match(/rv:([\d.]+)/)[1];
    } else if (ua.match(/firefox/) != null) {
        browserType = "火狐";
    } else if (ua.match(/ubrowser/) != null) {
        browserType = "UC";
    } else if (ua.match(/opera/) != null) {
        browserType = "欧朋";
    } else if (ua.match(/bidubrowser/) != null) {
        browserType = "百度";
    } else if (ua.match(/metasr/) != null) {
        browserType = "搜狗";
    } else if (ua.match(/tencenttraveler/) != null || ua.match(/qqbrowse/) != null) {
        browserType = "QQ";
    } else if (ua.match(/maxthon/) != null) {
        browserType = "遨游";
    } else if (ua.match(/chrome/) != null) {
        browserType = "chrome"
    } else if (ua.match(/safari/) != null) {
        browserType = "Safari";
    }
    return browserType;
}

/**
 * 获取url查询参数
 * @param {String} name 需要查询的key
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return r[2];
    return '';
}