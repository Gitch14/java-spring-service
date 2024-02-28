var multipleCardCarousel = document.querySelector("#carouselExampleControls");
var carouselWidth = $(".carousel-inner")[0].scrollWidth;
var cardWidth = $(".carousel-item").width();
var scrollPosition = 0;

if (window.matchMedia("(min-width: 768px)").matches) {
    var carousel = new bootstrap.Carousel(multipleCardCarousel, {
        interval: false,
    });

    //auto scroll
    function autoScroll() {
        if (scrollPosition < carouselWidth - cardWidth * 4) {
            scrollPosition += cardWidth;
        } else {
            scrollPosition = 0;
        }
        $("#carouselExampleControls .carousel-inner").animate(
            { scrollLeft: scrollPosition },
            600
        );
    }

    var intervalId = setInterval(autoScroll, 3000);

    $("#carouselExampleControls").hover(
        function () {
            clearInterval(intervalId);
        },
        function () {
            intervalId = setInterval(autoScroll, 3000);
        }
    );

    // var carouselWidth = $(".carousel-inner")[0].scrollWidth;
    // var cardWidth = $(".carousel-item").width();
    $("#carouselExampleControls .carousel-control-next").on("click", function () {
        if (scrollPosition < carouselWidth - cardWidth * 4) {
            scrollPosition += cardWidth;
            $("#carouselExampleControls .carousel-inner").animate(
                { scrollLeft: scrollPosition },
                600
            );
        }
    });

    $(multipleCardCarousel).on("slid.bs.carousel", function () {
        if (scrollPosition >= carouselWidth - cardWidth * 4) {
            scrollPosition = 0;
            $("#carouselExampleControls .carousel-inner").animate(
                { scrollLeft: scrollPosition },
                600
            );
        }
    });

    $("#carouselExampleControls .carousel-control-prev").on("click", function () {
        if (scrollPosition > 0) {
            scrollPosition -= cardWidth;
            $("#carouselExampleControls .carousel-inner").animate(
                { scrollLeft: scrollPosition },
                600
            );
        }
    });
} else {
    $(multipleCardCarousel).addClass("slide");
}