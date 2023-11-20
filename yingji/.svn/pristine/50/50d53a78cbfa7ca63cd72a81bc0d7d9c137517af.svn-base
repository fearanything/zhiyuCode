var list = document.querySelector('.menu_list');
        var menus = list.querySelectorAll('.menu_head');
        for (let i = 0; i < menus.length; i++) {
            menus[i].addEventListener('click', function() {
                alinks = this.nextElementSibling.children;
                if (this.className == 'menu_head') {
                    this.className = 'menu_head current';
                    for (let k = 0; k < alinks.length; k++) {
                        alinks[k].style.height = 'auto';
                        alinks[k].style.borderBottom='1px solid #003678';
                    }
                } else {
                    this.className = 'menu_head';
                    for (let k = 0; k < alinks.length; k++) {
                        alinks[k].style.height = '0';
                        alinks[k].style.borderBottom='0';
                    }
                }
                for (let j = 0; j < menus.length; j++) { //排他思想
                    if (j != i) {
                        menus[j].className = 'menu_head';
                        alist = menus[j].nextElementSibling.children;
                        for (let k = 0; k < alist.length; k++) {
                            alist[k].style.height = '0';
                            alist[k].style.borderBottom='0';
                        }
                    }
                }
            })
        }