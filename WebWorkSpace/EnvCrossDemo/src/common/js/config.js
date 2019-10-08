//分别添加开发环境、测试环境、生产环境下的不同baseUrl，并根据不同的npm指令获取相应的baseUrl


//常规的做法
// let mode="dev"; //可以设置：dev、test、prod
let baseUrl = "";

// if(mode=="dev"){
//   baseUrl=="http://api.xmdev.com";
// }else if(mode=="test"){
//   baseUrl=="http://api.xmtest.com";
// }else {
//   baseUrl=="http://api.xmprod.com";
// }

if (process.env.NODE_ENV == 'development') {
  baseUrl = "http://api.xmdev.com";
} else if (process.env.NODE_ENV == 'production') {
  baseUrl = "http://api.xmprod.com";
} else if (process.env.NODE_ENV == 'testing') {
  baseUrl = "http://api.xmtest.com";
}


export default {
  baseUrl
}





