
<%@ include file="jspf/header.jspf" %>
<section class="article-container">
<div class="article-container-header">
        <h1>Write Article</h1>
</div>
<div class="pages clearfix">
	<div class="hotel-reg-contain">
         
            <form method="post" action="update_artical" class="hotel-form" enctype="multipart/form-data">
		
                <div class="row">
                        
                </div>
		<div class="pages main-conten">
                    <div class="row">
                        <div class="col-6 ">
				<div class="form-group">
                                    <div class="form-group heding">
                                            <h2>
                                                    Edit Artical
                                                    <br>
                                                    <small class="text-muted sub-head"></small>
                                            </h2>
                                    </div>
                                    <div class="form-group">
                                        <img src="${artical.photo}" alt="artical-img"  id="articalimg" class="img-thumbnail">
                                        <input type="file" name="photo" class="form-control-file" onchange="displayPhoto(this)" value="${artical.photo}" >
                                    </div>
					
				</div>
				
			</div>

			<div class="col-6 right-conten">
				<div class="form-group">
					<label for="heading">Heading</label>
                                        <input type="text" name="heading" id="heading" class="form-control" value="${artical.heading}">
				</div>
				
				<div class="form-group">
					<label for="subheading">Sub-Heading</label>
                                        <input type="text" name="subheading" id="subheading" class="form-control" value="${artical.subheading}">
				</div>


		<div class="form-group">
			<label for="content">Content</label>
			<textarea name="content" id="content" class="form-control" rows="10" cols="5">${artical.content}</textarea>
		</div>
		
		<div class="form-group">
                    <select name="address" id="location" class="form-control form-control-lg">
                        <c:forEach var="location" items="${locs}">
                            <option value="${location.id}">${location.street},${location.city}</option>
                        </c:forEach>
                        <option value="">other</option>

                    </select>
                </div>
		
		<div class="form-group">
			<label>Tags</label>
			<div class="form-check">
                            <input type="checkbox" id="mounten" name="tag" value="mounten" class="form-check-input-inline">
				<label for="mounten">Mounten</label>
			</div>

			<div class="form-check">
				<input type="checkbox" id="View" name="tag" value="view" class="form-check-input-inline">
				<label for="view">View</label>
			</div>	
			
			<div class="form-check">
				<input type="checkbox" id="food" name="tag" value="food" class="form-check-input-inline">
				<label for="food">Food</label>
			</div>
		</div>
		
		<div class="form-group">
			<label for="type">Type</label>
			<select name="type" id="type" class="form-control">
                            <option value="documentary" <c:if test="${artical.type == 'documentary'}"> selected</c:if> >Documentary</option>
				<option value="promotion" <c:if test="${artical.type == 'promotion'}"> selected</c:if>>Promotion</option>
			</select>
		</div>

		<div class="form-group">
			
                        <input type="submit" name="posts" value="Post" class="btn btn-primary sub-btn">
                </div>
		</div>
	
                    
                    </div>
                </div>
                </form>
           
</div>
</section>

<script type="text/javascript">
    function displayPhoto(ele){
      console.log(ele.value);
      if (ele.files && ele.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#articalimg')
                    .attr('src', e.target.result)   
                     .min-width("200px")
                    .height(auto);             
            };

            reader.readAsDataURL(ele.files[0]);
        }
    }
  </script>

