<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<div class="row">

		<c:if test="${not empty message}">

			<c:choose>
				<c:when test="${msgType =='successful'}">
					<div class="col-xs-12">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							${message}
						</div>

					</div>
				</c:when>
				<c:otherwise>
					<div class="col-xs-12">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							${message}
						</div>

					</div>
				</c:otherwise>

			</c:choose>






		</c:if>










		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Prudct Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" placeholder="Product Name"
									class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" placeholder="Brand Name"
									class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Description:</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" rows="4"
									placeholder="Description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice"
									placeholder="Unit Price in Rs" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity"
									placeholder="Quantity Available" class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="file">File :</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" id="file" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select style="height:40px" id="categoryId" path="categoryId"
									class="form-control" items="${categories}" itemLabel="name"
									itemValue="id" />


								<c:if test="${product.id == 0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xl">Add
											Category</button>
									</div>
								</c:if>
							</div>
						</div>



						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="Submit"
									class="btn btn-primary" />

							</div>
						</div>
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="active" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto;">
				<table id="adminProductTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="modal fade" id="myCategoryModal" role="dialog"
			tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Add New Category</h4>
					</div>
					<div class="modal-body">
						<sf:form id="categoryForm" modelAttribute="category"
							action="${contextRoot}/manage/category" method="post" class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-md-4" for="category_name">Category
									Name</label>
								<div class="col-md-8">
									<sf:input class="form-control" type="text" path="name"  id="category_name"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="category_description">Category
									Description</label>
								<div class="col-md-8">
									<sf:textarea cols="" rows="5" class="form-control" type="text" path="description" id="category_description"/>
								</div>
							</div>
							<div class="form-group">
								 
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Add Category" class="btn btn-primary" />
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>



</div>
"
