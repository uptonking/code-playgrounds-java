'use strict';

importScripts('../supercluster.js');

var now = Date.now();

var index;

//示例的geojson是feature collection的形式，无length属性
getJSON('../dataseeds/mobike_testing.json', function (geojson) {
//getJSON('http://localhost:8889/dataseeds/mobike_loc.json', function (geojson) {

    //console.log(geojson.features)

    console.log('loaded ' + geojson.length + ' points JSON in ' + ((Date.now() - now) / 1000) + 's');

    //初始化supercluster对象
    index = supercluster({
        log: true,
        radius: 60,
        extent: 256,
        maxZoom: 17
    }).load(geojson.features);

    console.log(index.getTile(0, 0, 0));

    postMessage({ready: true});
});

//读取指定url的json文件，并执行callback函数
function getJSON(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Accept', 'application/json');
    xhr.onload = function () {
        console.log("onload");
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300 && xhr.response) {
        console.log("before callback");
            callback(xhr.response);
        }
    };
    console.log("before get dataseed");
    xhr.send();
}

//接收主线程发送过来的消息
self.onmessage = function (e) {
    if (e.data) {
        //返回指定区域和级别的聚簇和点
        postMessage(index.getClusters(e.data.bbox, e.data.zoom));
    }
};