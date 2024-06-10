// import number, {hello, str as name, arr, func} from './module.js';

// //const mainStr = '여기는 main.js 입니다.';
// const parent = document.querySelector("div");
// console.log(parent.innerHTML);

// console.log(number);
// console.log(name);
// console.log(arr);
// console.log(func);

//====================================================
// import * as mod from './module.js';
// console.log(mod.default);
// console.log(mod.str);
// console.log(mod.arr);
// console.log(mod.func);

//====================================================
// import {a} from "./a.js";
// import {b} from "./b.js";
import {a, b} from "./util.js";

console.log(a());
console.log(b());
