function killerror() {
    return true
};
window.onerror = killerror;
function lefttoggle(a) {
    if ($('#nav_' + a).attr('class') == 'div_bigmenu_nav_down') {
        $('#nav_' + a).removeClass("div_bigmenu_nav_down");
        $('#nav_' + a).addClass("div_bigmenu_nav_left");
        $('#ul_' + a).hide()
    } else {
        $('#nav_' + a).removeClass("div_bigmenu_nav_left");
        $('#nav_' + a).addClass("div_bigmenu_nav_down");
        $('#ul_' + a).show()
    }
};
$(function() {
    $('#list tr:even').addClass('bg2');
    $('#list tr').hover(function() {
        $(this).addClass('tr_hover')
    },
    function() {
        $(this).removeClass('tr_hover')
    });
    $('#list :checkbox').each(function() {
        $(this).click(function() {
            var a = $(this).val();
            if ($(this).attr('checked')) {
                $('#row_' + a).addClass('highlight')
            } else {
                $('#row_' + a).removeClass('highlight')
            }
        })
    })
});
function check_all(a) {
    if ($(a).is(':checked')) {
        $("input[name='id[]']").each(function() {
            $(this).prop('checked', true);
            $(this).parent().parent().addClass('highlight')
        })
    } else {
        $("input[name='id[]']").each(function() {
            $(this).prop('checked', false);
            $(this).parent().parent().removeClass('highlight')
        })
    }
};
function check_all_bycatid(a) {
    if ($(a).is(':checked')) {
        $("input[name='catid[]']").each(function() {
            $(this).prop('checked', true);
            $(this).parent().parent().addClass('highlight')
        })
    } else {
        $("input[name='catid[]']").each(function() {
            $(this).prop('checked', false);
            $(this).parent().parent().removeClass('highlight')
        })
    }
};
function check_all_byname(a) {
    if ($(a).is(':checked')) {
        $("input[name='name[]']").each(function() {
            $(this).prop('checked', true);
            $(this).parent().parent().addClass('highlight')
        })
    } else {
        $("input[name='name[]']").each(function() {
            $(this).prop('checked', false);
            $(this).parent().parent().removeClass('highlight')
        })
    }
};
function check_all_bynames(a) {
    if ($(a).is(':checked')) {
        $("input[name='names[]']").each(function() {
            $(this).prop('checked', true);
            $(this).parent().parent().addClass('highlight')
        })
    } else {
        $("input[name='names[]']").each(function() {
            $(this).prop('checked',false);
            $(this).parent().parent().removeClass('highlight')
        })
    }
};
function check_all_bycheckedid(a) {
    if ($(a).is(':checked')) {
        $("input[name='checkedid[]']").each(function() { 
            $(this).prop('checked',true);
            $(this).parent().parent().addClass('highlight');
        })
    } else {
        $("input[name='checkedid[]']").each(function() {
		   $(this).prop('checked',false);
           $(this).parent().parent().removeClass('highlight');
        })
    }
};
function confirmUrl(a, b) {
    if (confirm(a)) {
        self.location.href = b;
        return true
    }
};  function copy(a) {
    window.clipboardData.setData("Text", a);
    alert('澶嶅埗鎴愬姛,鐜板湪鍙互鐩存帴榛忚创!')
};
function createcat(a) {
    document.getElementById('hidecatid').value = a;
    document.getElementById('createcatform').submit()
}