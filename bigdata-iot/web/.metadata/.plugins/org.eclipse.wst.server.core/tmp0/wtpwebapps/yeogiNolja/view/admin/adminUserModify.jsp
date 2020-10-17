<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-box2 icon-gradient bg-amy-crisp"> </i>
			</div>
			<div>
				Edit ${userDetail.name }'s Information
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
			<form action="adminUserModifyImpl.mc" method="post">
				<h5 class="card-title">Modify User Info</h5>
				<table class="mb-0 table">
					<tbody>
						<tr>
							<th>E-mail</th>
							<th>${userDetail.email}
								<input type="hidden" name="email" value="${userDetail.email}">
							</th>
						</tr>
						<tr>
							<th>Name</th>
							<td><input class="form-control" type="text"
								name="name" value="${userDetail.name}" />
							</td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input class="form-control" type="text"
								name="pwd" value="${userDetail.pwd}" />
							</td>
						</tr>
						<tr>
							<th>Administrator</th>
							<td>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio1" class="custom-control-input"
										name="admin_yn" value="Y" 
										<c:if test="${userDetail.admin_yn == 'Y' || userDetail.admin_yn == 'y'}">checked</c:if> 
										/> <label class="custom-control-label"
										for="exampleCustomRadio1"> YES </label>
								</div>
								<div class="custom-radio custom-control">
									<input type="radio" id="exampleCustomRadio2" class="custom-control-input"
										name="admin_yn" value="N" 
										<c:if test="${userDetail.admin_yn == 'N' || userDetail.admin_yn == 'n'}"> checked</c:if>
										/> <label class="custom-control-label"
										for="exampleCustomRadio2"> NO </label>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="mb-2 mr-2 btn btn-primary btn-lg btn-block">Modify </button>
				</div>
			</div>
			</form>
			</div>
		</div>
	</div>
</div>
