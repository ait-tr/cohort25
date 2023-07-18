const showImageButton  = document.getElementById('showImage');
const image = document.getElementById('helloImage');

showImageButton.addEventListener('click',()=>{
    image.style.display = 'block';
    setTimeout(()=>{ image.style.display = 'none';},5000);
});