function changeSize() {
	var myObj = document.getElementById('best-box')
	var myWidth = myObj.offsetWidth
	var myHeight = myObj.offsetHeight
	var bodyWidth = document.body.offsetWidth
	var bodyHeight = window.innerHeight
	var scaleNum = bodyWidth/myWidth
	var marginNum=(bodyHeight-myHeight*scaleNum)/2
	// console.log(bodyWidth)
	// console.log(window.screen.height)
	myObj.style.transformOrigin = '0% 0%'
	myObj.style.transform = 'scale('+scaleNum+')'
	myObj.style.marginTop=marginNum+'px'
	
}
changeSize();
window.onresize=(function(){
    changeSize();
})