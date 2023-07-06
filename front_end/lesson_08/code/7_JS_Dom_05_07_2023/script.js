// С помощью метода getElementById мы получаем ссылку на тот элемент,
// id которого передадим в качестве параметров метода  - однострочный комментарий
/* 
aa
aa  --- многострочный комментарий
aa
aa
*/
// const - константа, переприсваивать зачение запрещено
// let - переменная, переприсваивать зачение можно
let t = setInterval(move, 20);
let pos = 0;
// let flag = true;
const box = document.getElementById('box');

// 10 + 'px' => '10px'
// box.style.left = 10 + 'px';

// function move() {
//     pos++;
//     if (pos == 150) {
//         clearInterval(t);
//         t = setInterval(moveBack, 20);

//     };
//     box.style.left = pos + 'px';
//     box.style.top = pos + 'px';
// }

// function moveBack() {
//     pos--;
//     if (pos == 0) {
//         clearInterval(t);
//         t = setInterval(move, 20);
//     };
//     box.style.left = pos + 'px';
//     box.style.top = pos + 'px';
// }
let dir = 1
function move() {
    // 41 и 42 строка идентичны pos += dir;
    pos = pos + dir;
    if (pos == 0 || pos == 150) {
        dir = -dir;
    }
    box.style.left = pos + 'px';
    box.style.top = pos + 'px';
//     // flag ? pos++ : pos--;
//     // if (pos == 0 || pos == 150) {
//     //     flag = !flag;
//     // }
//     // box.style.left = pos + 'px';
//     // box.style.top = pos + 'px';

//     if (pos == 150) {
//         flag = false;
//     }
//     if (pos == 0) {
//         flag = true;
//     }

//     if (flag) {
//         pos++;
//     } else {
//         pos--;
//     }
    
//     box.style.left = pos + 'px';
//     box.style.top = pos + 'px';
    
//     // pos++;
//     // if (pos == 150) {
//     //     clearInterval(t);
//     // };
//     // box.style.left = pos + 'px';
//     // box.style.top = pos + 'px';
}