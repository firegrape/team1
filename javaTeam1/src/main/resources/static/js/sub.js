
$(function(){
    $('.nav> li').mouseover(function(){
        $(this).children('.sub').stop().slideDown();
    });
    $('.nav> li').mouseleave(function(){
        $(this).children('.sub').stop().slideUp();
    });
});
