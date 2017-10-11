<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  type="text/javascript"  src="/FinancingProject/js/jquery-3.2.0.min.js">
</script>
<link href="/FinancingProject/kongming/css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/kongming/CSSPlugin.min.js"></script>
<script type="text/javascript" src="/FinancingProject/kongming/EasePack.min.js"></script>
<script type="text/javascript" src="/FinancingProject/kongming/TweenLite.min.js"></script>
</head>
     <script>
     /*
     11     ① 用setInterval(draw, 33)设定刷新间隔
     12
     13     ② 用String.fromCharCode(1e2+Math.random()*33)随机生成字母
     14
     15     ③ 用ctx.fillStyle=’rgba(0,0,0,.05)’; ctx.fillRect(0,0,width,height); ctx.fillStyle=’#0F0′; 反复生成opacity为0.5的半透明黑色背景
     16
     17     ④ 用x = (index * 10)+10;和yPositions[index] = y + 10;顺序确定显示字母的位置
     18
     19     ⑤ 用fillText(text, x, y); 在指定位置显示一个字母 以上步骤循环进行，就会产生《黑客帝国》的片头效果。
     20 */
  
     /*    $(document).ready(function() {
                //设备宽度
                var s = window.screen;
                 var width = q.width = s.width;
                var height = q.height;
                var yPositions = Array(300).join(0).split('');
                 var ctx = q.getContext('2d');
                var draw = function() {
                         ctx.fillStyle = 'rgba(0,0,0,.05)';
                         ctx.fillRect(0, 0, width, height);
                         ctx.fillStyle = 'green';//代码颜色
                         ctx.font = '12pt Georgia';
                         yPositions.map(function(y, index) {
                                 text = String.fromCharCode(1e2 + Math.random() * 330);
                                 x = (index * 10) + 10;
                                 q.getContext('2d').fillText(text, x, y);
                                 if (y > Math.random() * 1e4) {
                                        yPositions[index] = 0;
                                     } else {
                                        yPositions[index] = y + 10;
                                     }
                            });
                     };
                RunMatrix();
               function RunMatrix() {
                        Game_Interval = setInterval(draw,30);
                     }
             });  */
             
             
             
             
             
     </script>
     </head>
     
     
    <style>html, body {
  width: 100%;
  height: 100%;
  overflow: hidden;
  font-family: 'Rubik Mono One', sans-serif;
/* background: #22292C; */
}

svg {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  z-index: 0;
}

.input {
  position: absolute;
  z-index: 1;
  bottom: 0px;
  font-size: 20px;
  text-align: center;
  left: 50%;
  transform: translateX(-50%);
  font-family: helvetica, sans-serif;
  bottom: 20px;
  background: none;
  border: 1px solid #ddd;
  color: #eee;
}

.text, .offscreen-text {
  width: 100%;
  top: 50%;
  transform: translateY(-50%);
  display: block;
  position: absolute;
  margin: 0;
}

.offscreen-text {
  text-align: center;
  top: -9999px;
}

.text span {
  position: absolute;
}

</style> 
 <body>
 <!--  这个是黑客帝国的特效-->
   <!-- <div align="center" style=" position:fixed; left:0; top:0px; width:100%; height:100%;">
           <canvas id="q" width="1920" height="900"></canvas>
     </div> -->
 
   <div>
 
<!-----HEADER STAR----->
  <canvas   style="z-index:-1;"    id="canvas"   width="1920" height="900" ></canvas>  
<!-----HEADER END----->
<!--用来解决视频右键菜单，用于视频上面的遮罩层 START-->
 <div class="videozz"></div> 
<!--用来解决视频右键菜单，用于视频上面的遮罩层 END-->



<p id="offscreen-text" class="offscreen-text" style="font-size: 61.2941px;"><span></span><span></span><span></span><span></span><span></span><span></span><span> </span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></p>
<p id="text" class="text" style="font-size: 61.2941px; height: 61.2941px; line-height: 61.2941px;"><span style="color: rgb(251, 219, 74); transform: matrix(1, 0, 0, 1, 131, 0); opacity: 1;"></span><span style="color: rgb(243, 147, 74); transform: matrix(1, 0, 0, 1, 183, 0); opacity: 1;"></span><span style="color: rgb(235, 84, 125); transform: matrix(1, 0, 0, 1, 235, 0); opacity: 1;"></span><span style="color: rgb(159, 106, 167); transform: matrix(1, 0, 0, 1, 287, 0); opacity: 1;"></span><span style="color: rgb(84, 118, 179); transform: matrix(1, 0, 0, 1, 339, 0); opacity: 1;"></span><span style="color: rgb(43, 177, 155); transform: matrix(1, 0, 0, 1, 391, 0); opacity: 1;"></span><span style="color: rgb(112, 185, 132); transform: matrix(1, 0, 0, 1, 443, 0); opacity: 1;"> </span><span style="color: rgb(251, 219, 74); transform: matrix(1, 0, 0, 1, 495, 0); opacity: 1;"></span><span style="color: rgb(243, 147, 74); transform: matrix(1, 0, 0, 1, 547, 0); opacity: 1;"></span><span style="color: rgb(235, 84, 125); transform: matrix(1, 0, 0, 1, 599, 0); opacity: 1;"></span><span style="color: rgb(159, 106, 167); transform: matrix(1, 0, 0, 1, 651, 0); opacity: 1;"></span><span style="color: rgb(84, 118, 179); transform: matrix(1, 0, 0, 1, 703, 0); opacity: 1;"></span><span style="color: rgb(43, 177, 155); transform: matrix(1, 0, 0, 1, 755, 0); opacity: 1;"></span><span style="color: rgb(112, 185, 132); transform: matrix(1, 0, 0, 1, 807, 0); opacity: 1;"></span><span style="color: rgb(251, 219, 74); transform: matrix(1, 0, 0, 1, 859, 0); opacity: 1;"></span></p>
<svg id="svg" height="617" width="1042" viewBox="0 0 1042 617">
</svg>
<input type="text" class="input" , id="input">

</div>




<script>
//宇宙特效
"use strict";
var canvas = document.getElementById('canvas'),
  ctx = canvas.getContext('2d'),
   w = canvas.width = 1455,
  h = canvas.height = 545,  
  hue = 217,
  stars = [],
  count = 0,
  maxStars = 1500;//星星数量

var canvas2 = document.createElement('canvas'),
  ctx2 = canvas2.getContext('2d');
canvas2.width = 100;
canvas2.height = 100;
var half = canvas2.width / 2,
  gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
gradient2.addColorStop(0.025, '#CCC');
gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
gradient2.addColorStop(1, 'transparent');

ctx2.fillStyle = gradient2;
ctx2.beginPath();
ctx2.arc(half, half, half, 0, Math.PI * 2);
ctx2.fill();

// End cache

function random(min, max) {
  if (arguments.length < 2) {
    max = min;
    min = 0;
  }

  if (min > max) {
    var hold = max;
    max = min;
    min = hold;
  }

  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function maxOrbit(x, y) {
  var max = Math.max(x, y),
    diameter = Math.round(Math.sqrt(max * max + max * max));
  return diameter / 2;
  //星星移动范围，值越大范围越小，
}

  var Star = function() {
  this.orbitRadius = random(maxOrbit(w, h));
  this.radius = random(60, this.orbitRadius) / 8; 
  //星星大小
  this.orbitX = w / 2;
  this.orbitY = h / 2;
  this.timePassed = random(0, maxStars);
  this.speed = random(this.orbitRadius) / 50000; 
  //星星移动速度
  this.alpha = random(2, 10) / 10;
  count++;
  stars[count] = this;
}

Star.prototype.draw = function() {
  var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
    y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
    twinkle = random(10);
  if (twinkle === 1 && this.alpha > 0) {
    this.alpha -= 0.05;
  } else if (twinkle === 2 && this.alpha < 1) {
    this.alpha += 0.05;
  }
  ctx.globalAlpha = this.alpha;
  ctx.drawImage(canvas2, x - this.radius / 2, y - this.radius / 2, this.radius, this.radius);
  this.timePassed += this.speed;
}

for (var i = 0; i < maxStars; i++) {
  new Star();
}

function animation() {
  ctx.globalCompositeOperation = 'source-over';
  ctx.globalAlpha = 0.5; //尾巴
  ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
  ctx.fillRect(0, 0, w, h)
  ctx.globalCompositeOperation = 'lighter';
  for (var i = 1, l = stars.length; i < l; i++) {
    stars[i].draw();
  };

  window.requestAnimationFrame(animation);
}

animation();
</script>



<script>const selectSVG = id => {
  const el = document.getElementById(id);
  return new SVGElement(el);
};

const createSVG = type => {
  const el = document.createElementNS('http://www.w3.org/2000/svg', type);
  return new SVGElement(el);
};

class SVGElement {
  constructor(element) {
    this.element = element;
  }

  set(attributeName, value) {
    this.element.setAttribute(attributeName, value);
  }

  style(property, value) {
    this.element.style[property] = value;
  }
}

const colors = [
  { main: '#FBDB4A', shades: ['#FAE073', '#FCE790', '#FADD65', '#E4C650'] },
  { main: '#F3934A', shades: ['#F7B989', '#F9CDAA', '#DD8644', '#F39C59'] },
  { main: '#EB547D', shades: ['#EE7293', '#F191AB', '#D64D72', '#C04567'] },
  { main: '#9F6AA7', shades: ['#B084B6', '#C19FC7', '#916198', '#82588A'] },
  { main: '#5476B3', shades: ['#6382B9', '#829BC7', '#4D6CA3', '#3E5782'] },
  { main: '#2BB19B', shades: ['#4DBFAD', '#73CDBF', '#27A18D', '#1F8171'] },
  { main: '#70B984', shades: ['#7FBE90', '#98CBA6', '#68A87A', '#5E976E'] }
];
const svg = selectSVG('svg');
const text = document.getElementById('text');
const offscreenText = document.getElementById('offscreen-text');
const input = document.getElementById('input');
let width = window.innerWidth;
let height = window.innerHeight;
let textSize = 0;
let textCenter = 0;
const letters = [];

const prompt=['kong',' ','ming',' ','F','i','n','a','n','c','i','n','g'];
//const prompt=['孔','明','投','资','管','理','有','限','公','司'];
let runPrompt = true;

const resizePage = () => {
  width = window.innerWidth;
  height = window.innerHeight;
  svg.set('height', height);
  svg.set('width', width);
  svg.set('viewBox', `0 0 ${width} ${height}`);
  resizeLetters();
}

const resizeLetters = () => {
  textSize = width / (letters.length+2);
  if (textSize > 100) textSize = 100;
  text.style.fontSize = `${textSize}px`;
  text.style.height = `${textSize}px`;
  text.style.lineHeight = `${textSize}px`;
  offscreenText.style.fontSize = `${textSize}px`;
  const textRect = text.getBoundingClientRect();
  textCenter = textRect.top + textRect.height/2;
  positionLetters();
};

const positionLetters = () => {
  letters.forEach(letter => {
    const timing = letter.shift ? 0.1 : 0;
    TweenLite.to(letter.onScreen, timing, {x:letter.offScreen.offsetLeft+'px', ease: Power3.easeInOut});
    letter.shift = true;
  });
}

const animateLetterIn = letter => {
  const yOffset = (0.5+Math.random()*0.5) * textSize;
  TweenLite.fromTo(letter, 0.4, {scale:0}, {scale:1, ease: Back.easeOut});
  TweenLite.fromTo(letter, 0.4, {opacity:0}, {opacity: 1, ease: Power3.easeOut});
  TweenLite.to(letter, 0.2, {y:-yOffset, ease: Power3.easeInOut});
  TweenLite.to(letter, 0.2, {y:0, ease: Power3.easeInOut, delay: 0.2});
  const rotation = -50 + Math.random()*100;
  TweenLite.to(letter, 0.2, {rotation: rotation, ease: Power3.easeInOut});
  TweenLite.to(letter, 0.2, {rotation: 0, ease: Power3.easeInOut, delay: 0.2});
}

const addDecor = (letter, color) => {
  setTimeout(() => {
    var rect = letter.getBoundingClientRect();
    const x0 = letter.offsetLeft + letter.offsetWidth/2;
    const y0 = textCenter - textSize*0.5;
    const shade = color.shades[Math.floor(Math.random()*4)];
    for (var i = 0; i < 8; i++) addTri(x0, y0, shade);
    for (var i = 0; i < 8; i++) addCirc(x0, y0);
  }, 150);
};

const addTri = (x0, y0, shade) => {
  const tri = createSVG('polygon');
  const a = Math.random();
  const a2 = a + (-0.2 + Math.random()*0.4);
  const r = textSize*0.52;
  const r2 = r + textSize*Math.random()*0.2;
  const x = x0 + r * Math.cos(2 * Math.PI * a);
  const y = y0 + r * Math.sin(2 * Math.PI * a);
  const x2 = x0 + r2 * Math.cos(2 * Math.PI * a2);
  const y2 = y0 + r2 * Math.sin(2 * Math.PI * a2);
  const triSize = textSize * 0.1;
  const scale = 0.3 + Math.random()*0.7;
  const offset = triSize*scale;
  tri.set('points', `0,0 ${triSize*2},0 ${triSize},${triSize*2}`);
  tri.style('fill', shade);
  svg.element.appendChild(tri.element);
  TweenLite.fromTo(tri.element, 0.6, {rotation: Math.random()*360, scale: scale, x: x-offset, y: y-offset, opacity: 1}, {x: x2-offset, y: y2-offset, opacity: 0, ease: Power1.easeInOut, onComplete: () => {
    svg.element.removeChild(tri.element);
  }});
}

const addCirc = (x0, y0) => {
  const circ = createSVG('circle');
  const a = Math.random();
  const r = textSize*0.52;
  const r2 = r + textSize;
  const x = x0 + r * Math.cos(2 * Math.PI * a);
  const y = y0 + r * Math.sin(2 * Math.PI * a);
  const x2 = x0 + r2 * Math.cos(2 * Math.PI * a);
  const y2 = y0 + r2 * Math.sin(2 * Math.PI * a);
  const circSize = textSize * 0.05 * Math.random();
  circ.set('r', circSize);
  circ.style('fill', '#eee');
  svg.element.appendChild(circ.element);
  TweenLite.fromTo(circ.element, 0.6, {x: x-circSize, y: y-circSize, opacity: 1}, {x: x2-circSize, y: y2-circSize, opacity: 0, ease: Power1.easeInOut, onComplete: () => {
    svg.element.removeChild(circ.element);
  }});
}

const addLetter = (char, i) => {
  const letter = document.createElement('span');
  const oLetter = document.createElement('span');
  letter.innerHTML = char;
  oLetter.innerHTML = char;
  text.appendChild(letter);
  const color = colors[i%colors.length];
  letter.style.color = color.main;
  offscreenText.appendChild(oLetter);
  letters[i] = {offScreen: oLetter, onScreen: letter, char: char};
  animateLetterIn(letter);
  addDecor(oLetter, color);
}

const addLetters = value => {
  value.forEach((char, i) => {
    if (letters[i] && letters[i].char !== char) {
      letters[i].onScreen.innerHTML = char;
      letters[i].offScreen.innerHTML = char;
      letters[i].char = char;
    }
    if (letters[i] === undefined) {
      addLetter(char, i);
    }
  });
};

const animateLetterOut = (letter, i) => {
  TweenLite.to(letter.onScreen, 0.1, {scale: 0, opacity: 0, ease: Power2.easeIn, onComplete: () => {
    console.log('removing');
    console.log(letter);
    offscreenText.removeChild(letter.offScreen);
    text.removeChild(letter.onScreen);
    positionLetters();
  }});
  letters.splice(i, 1);
}

const removeLetters = value => {
  for (let i = letters.length-1; i >= 0; i--) {
    const letter = letters[i];
    if (value[i] === undefined) {
      animateLetterOut(letter, i)
    }
  }
}

const onInputChange = () => {
  const value = input.value === '' ? [] : input.value.toLowerCase().split('');
  addLetters(value);
  removeLetters(value);
  resizeLetters();
};

const keyup = (e) => {
  if (runPrompt) {
    input.value = '';
    runPrompt = false;
  };
  onInputChange();
}

const addPrompt = (i) => {
  setTimeout(() => {
    if (runPrompt && prompt[i]) {
      input.value = input.value + prompt[i];
      onInputChange();
      addPrompt(i+1);
    }
  }, 300);
}
  
resizePage();
window.addEventListener('resize', resizePage);
input.addEventListener('keyup', keyup);
input.focus();
addPrompt(0);
</script>


</body>
</html>