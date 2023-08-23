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
const t = setInterval(move, 20);
let pos = 0;
const box = document.getElementById('box');

// 10 + 'px' => '10px'
// box.style.left = 10 + 'px';

function move() {
    pos++;
    if (pos == 150) {
        clearInterval(t);
    };
    box.style.left = pos + 'px';
    box.style.top = pos + 'px';
}