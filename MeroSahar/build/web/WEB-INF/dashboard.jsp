
<%@page session="true"%>

<section class="body-image-container">
<div class="actual">
        <div class="content-body">
                <h1>Going Places</h1>
                <p>I haven't been everywhere, but it's on my list</p>
        </div>
</div>
</section>
<section class="search-container">
<div class="actual search-content">
        <span>Traveling is fun.</span><p> Take your time for choosing the best place to spend your weekend and holidays.</p>

        <input type="text" name="search_box" placeholder="Search for places..">
        <input type="submit" name="search-btn" class="search-button" value="Search">
</div>
</section>
<section class="sponsors-container clearfix">
<div class="actual">
        <div class="sponsors-title">
                As featured in
        </div>
        <div class="vertical-bar"></div>
        <div class="sponsors-list clearfix">
                <ul>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>
                        <li class="sponsors-list-dep">
                                <img src="images/kistCollegeLogo.png">
                        </li>

                </ul>
        </div>
</div>
</section>
<section class="video-container">
<div class="video-content">
        <video width="720px" height="480px" controls>
      <source src="images/Visit Nepal 2020 - Lifetime Experience ( 720 X 1280 ).mp4" type=video/ogg>
      <source src="/build/videos/arcnet.io(7-sec).mp4" type=video/mp4>
    </video>
</div>
</section>
<section class="top-views-container">
<div class="actual">
        <div class="top-views-container-header clearfix">
                <h1>Top 10 things you should and must do in Nepal </h1>
                <div class="go-to-page"><a href="#">Go to Page</a></div>
        </div>
        <div class="top-ten-lists clearfix">
                <ul>
                        <li>
                                <a href="">
                                <div class="list-article">
                                        <img src="images/photo-5.jpg">
                                        <h2>Top places you must do visit in nepal</h2>
                                        <p>Lorem-ispum is a dummy text </p>
                                </div>
                        </a>		
                        </li>
                        <li>
                                <a href="">
                                <div class="list-article">
                                        <img src="images/photo-6.jpg">
                                        <h2>Top Things you must try to have in nepal</h2>
                                        <p>Lorem-ispum is a dummy text </p>
                                </div>
                        </a>		
                        </li>
                        <li>
                                <a href="">
                                <div class="list-article">
                                        <img src="images/photo-3.jpg">
                                        <h2>Top places you must try to go for hiking in nepal</h2>
                                        <p>Lorem-ispum is a dummy text </p>
                                </div>
                        </a>		
                        </li>
                        <li>
                                <a href="">
                                <div class="list-article">
                                        <img src="images/photo-4.jpg">
                                        <h2>Top mountains in nepal</h2>
                                        <p>Lorem-ispum is a dummy text </p>
                                </div>
                        </a>		
                        </li>
                </ul>

        </div>
</div>
</section>
<!--<table>-->
<%--<c:forEach var="artical" items="${articalList}">
    <tr>
        <td>${artical.heading}</td>
        <td>${artical.userid.firstname}</td>
        <td>${artical.locationid.city}</td>
    </tr>
</c:forEach>--%>
<!--</table>  -->
<section class="article-container">
<div class="article-container-header">
        <h1>Main Article</h1>
</div>
<div class="actual clearfix">
    <c:set var = "i" value = "${0}"/>
    <c:forEach var="artical" items="${articalList}">
       
        <div class="article-details">
                <a href="">
                <div class="article-image-content">
                        <img src="${artical.photo}">
                </div>
                <div class="article-content-writer clearfix">
                        <div class="writer-image">
                                <!-- <img src="images/admin-icon.png"> -->
                        </div>
                        <h3 class="writer-name">${artical.userid.firstname} ${artical.userid.lastname}</h3>
                        <p class="writer-date">${artical.date}</p>
                </div>
                <div class="article-header">
                        <h1>${artical.heading}, ${artical.subheading}</h1>
                </div>
                <div class="article-description">
                        <p>${artical.content}</p>
                </div>
                <hr width="84.6%" style="margin-left: 88px; margin-bottom: 20px;">
                <div class="article-views-comment-like clearfix">
                        <div class="count-views">218 views</div>
                        <div class="comment"><a href="">Write a comment</a></div>
                        <div class="like-counts"><a href="#"><i class="fa fa-heart"></i></a>150</div>
                        <p class="see-more"><a href="#">See more...</a></p>
                </div>
                </a>
        </div>
       
       
    </c:forEach>
        <div class="go-to-page"><a href="#">Go to Page >></a></div>
</div>
</section>
<section class="gallery-container">
<div class="gallery-content actual clearfix">
        <div class="our-blog-content actual">
<span class="kaushan-script-text what-we-do">Our Gallery</span>
<h1>
Latest pictures
</h1>
        <div class="gallery-images l clearfix">
                <ul>
                        <li class="gallery-image-file">
                                <img src="images/img3.jpg">
                        </li>
                        <li class="gallery-image-file">
                            <img src="images/img4.jpg">
                        </li>
                        <li class="gallery-image-file">
                                <img src="images/img3.jpg">
                        </li>
                        <li class="gallery-image-file">
                            <img src="images/img4.jpg">
                        </li>
                </ul>
        </div>
        <div class="gallery-images c clearfix">
                <ul>
                        <li class="gallery-image-file">
                            <img src="images/photo-9.jpg">
                        </li>
                        <li class="gallery-image-file">
                            <img src="images/photo-9.jpg">
                        </li>
                </ul>
        </div>
        <div class="gallery-images rclearfix">
                <ul>
                        <li class="gallery-image-file">
                                <img src="images/img3.jpg">
                        </li>
                        <li class="gallery-image-file">
                            <img src="images/img4.jpg">
                        </li>
                        <li class="gallery-image-file">
                                <img src="images/img3.jpg">
                        </li>
                        <li class="gallery-image-file">
                            <img src="images/img4.jpg">
                        </li>
                </ul>
        </div>
</div>
</section>
<section class="our-blog-container">
<div class="our-blog-content actual">
<span class="kaushan-script-text what-we-do">Our Stories</span>
<h1>
Latest Blog
</h1>
<div class="blog-image clearfix">
<ul>
<li class="blog-list">
<div class="main-image">
    <img src="images/photo-12.jpg" alt="photo-12.png" class="init-image">
    <div class="date-view">
        <span>15</span>
        <p>Jan</p>
    </div>
</div>
<div class="blog-info">
    <h1>Basantapur Durbar Square, Kathmandu</h1>
    <p class="robotto-text">This is a place that is really first time to me. So much crowd. People is so busy here..</p>
</div>
<div class="line-rectangle our-blog-line-separator"></div>
<div class="like-views clearfix">
        <a href="">
                <img src="images/eye.png" alt="eye.png">
                <p class="view-num robotto-text"> 542</p>
        </a>
        <a href="">
                <img src="images/message.png" alt="message.png">
                <p class="comment-num robotto-text"> 17</p>
        </a>
</div>
</li>
<li class="blog-list">
<div class="main-image">
    <img src="images/photo-8.jpg" alt="photo-8.jpg" class="init-image">
    <div class="date-view">
        <span>15</span>
        <p>Jan</p>
    </div>
</div>
<div class="blog-info">
    <h1>Syambhunath, Kathmandu</h1>
    <p class="robotto-text">i wonder that if i am a buddhist monk.</p>
</div>
<div class="line-rectangle our-blog-line-separator"></div>
<div class="like-views clearfix">
<div class="like-views clearfix">
        <a href="">
                <img src="images/eye.png" alt="eye.png">
                <p class="view-num robotto-text"> 542</p>
        </a>
        <a href="">
                <img src="images/message.png" alt="message.png">
                <p class="comment-num robotto-text"> 17</p>
        </a>
</div>	
</li>
<li class="blog-list">
<div class="main-image">
    <img src="images/photo-13.jpg" alt="photo-13.jpg" class="init-image">
    <div class="date-view">
        <span>15</span>
        <p>Jan</p>
    </div>
</div>
<div class="blog-info">
    <h1>Living Goddess "Kumari"</h1>
    <p class="robotto-text">Kumari a living goddess in nepal. I wonder what a culture that people worship a vargin woman like a god.</p>
</div>
<div class="line-rectangle our-blog-line-separator"></div>
<div class="like-views clearfix">
        <a href="">
                <img src="images/eye.png" alt="eye.png">
                <p class="view-num robotto-text"> 542</p>
        </a>
        <a href="">
                <img src="images/message.png" alt="message.png">
                <p class="comment-num robotto-text"> 17</p>
        </a>
</div>
</li>
</ul>
</div>
</div>
</section>