<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-magic-wand icon-gradient bg-mixed-hopes"> </i>
			</div>
			<div>
				User List
				<div class="page-title-subheading">Tables are the backbone of
					almost all web applications.</div>
			</div>
		</div>
		<div class="page-title-actions">
			<button type="button" data-toggle="tooltip" title="Example Tooltip"
				data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
				<i class="fa fa-star"></i>
			</button>
			<div class="d-inline-block dropdown">
				<button type="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"
					class="btn-shadow dropdown-toggle btn btn-info">
					<span class="btn-icon-wrapper pr-2 opacity-7"> <i
						class="fa fa-business-time fa-w-20"></i>
					</span> Buttons
				</button>
			</div>
		</div>
	</div>
</div>

<jsp:include page="${message}"></jsp:include>

<div class="row">
	<div class="col-lg-6-2">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">ALL Users</h5>
				<table class="mb-0 table">
					<thead>
						<tr>
							<th>E-MAIL</th>
							<th>NAME</th>
							<th>PASSWORD</th>
							<th>TYPE</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${userList}">
							<tr>
								<td scope="row">${u.email}</td>
								<th>${u.name}</th>
								<td>${u.pwd}</td>
								<td>
									<c:if test="${u.admin_yn == 'Y'}">
										<div class="mb-2 mr-2 badge badge-pill badge-success">Admin</div></c:if>
									<c:if test="${u.admin_yn == 'N'}">
										<div class="mb-2 mr-2 badge badge-pill badge-warning">Customer</div></c:if>
								</td>
								<td>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-info" 
									onclick="location.href='adminUserModify.mc?id=${u.email}'">Edit</button>
									<button class="mb-2 mr-2 btn-transition btn btn-outline-danger">Delete</button>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
