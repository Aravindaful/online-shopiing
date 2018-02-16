<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Prudct Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" placeholder="Product Name"
									class="form-control" />
								 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" placeholder="Brand Name"
									class="form-control" />
								 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Description:</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" rows="4" placeholder="Description"
									class="form-control"  /> 
								 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" placeholder="Unit Price in &#8377"
									class="form-control" />
								 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" placeholder="Quantity Available"
									class="form-control" />
								 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								 <sf:select style="height:40px" id="categoryId" path="categoryId" class="form-control"
								 items="${categories}"
								 itemLabel="name"
								 itemValue="id"
								 />
								 
							</div>
						</div>
						
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="Submit"  
									class="btn btn-primary" />
								 
							</div>
						</div>
						<sf:hidden path="id"/>
						<sf:hidden path="code"/>
						<sf:hidden path="supplierId"/>
						<sf:hidden path="active"/>
						<sf:hidden path="purchases"/>
						<sf:hidden path="views"/>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
"