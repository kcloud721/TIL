<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-car icon-gradient bg-mean-fruit"> </i>
			</div>
			<div>
				Analytics Dashboard
				<div class="page-title-subheading">This is an example
					dashboard created using build-in elements and components.</div>
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
	<div class="col-md-6 col-xl-4">
		<div class="card mb-3 widget-content bg-midnight-bloom">
			<div class="widget-content-wrapper text-white">
				<div class="widget-content-left">
					<div class="widget-heading">Total Hotels</div>
					<div class="widget-subheading">DB에 등록된 호텔 수</div>
				</div>
				<div class="widget-content-right">
					<div class="widget-numbers text-white">
						<span>${hotelTotalNum}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6 col-xl-4">
		<div class="card mb-3 widget-content bg-arielle-smile">
			<div class="widget-content-wrapper text-white">
				<div class="widget-content-left">
					<div class="widget-heading">Reservations Staying Today</div>
					<div class="widget-subheading">오늘 숙박 중인 예약</div>
				</div>
				<div class="widget-content-right">
					<div class="widget-numbers text-white">
						<span>${rsvTotalNum}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6 col-xl-4">
		<div class="card mb-3 widget-content bg-grow-early">
			<div class="widget-content-wrapper text-white">
				<div class="widget-content-left">
					<div class="widget-heading">Users</div>
					<div class="widget-subheading">보유 회원 수</div>
				</div>
				<div class="widget-content-right">
					<div class="widget-numbers text-white">
						<span>${userTotalNum}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="d-xl-none d-lg-block col-md-6 col-xl-4">
		<div class="card mb-3 widget-content bg-premium-dark">
			<div class="widget-content-wrapper text-white">
				<div class="widget-content-left">
					<div class="widget-heading">Products Sold</div>
					<div class="widget-subheading">Revenue streams</div>
				</div>
				<div class="widget-content-right">
					<div class="widget-numbers text-warning">
						<span>$14M</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-lg-6">
		<div class="main-card mb-3 card">
			<div class="card-header">
				Active Users
			</div>
			<div class="table-responsive">
				<table
					class="align-middle mb-0 table table-borderless table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center"> </th>
							<th class="text-center">Name</th>
							<th class="text-center">Email</th>
							<th class="text-center">Type</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="num" value="0"/>
						<c:forEach var="u" items="${userList}">
							<tr>
								<td class="text-center"><img width="40" class="rounded-circle"
													src="assets/images/avatars/<c:out value="${num = num%8 + 1}" />.jpg" alt=""></td>
								<th class="text-center" scope="row">${u.name}</th>
								<td class="text-center">${u.email}</td>
								<td class="text-center">
									<c:if test="${u.admin_yn == 'Y'}">
										<div class="mb-2 mr-2 badge badge-pill badge-success">Admin</div></c:if>
									<c:if test="${u.admin_yn == 'N'}">
										<div class="mb-2 mr-2 badge badge-pill badge-warning">Customer</div></c:if>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="d-block text-center card-footer">
				<button class="btn-wide btn btn-success"
				onclick="location.href='adminUserList.mc'">View</button>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-lg-6">
		<div class="mb-3 card">
			<div class="card-header-tab card-header">
				<div class="card-header-title">
					<i class="header-icon lnr-rocket icon-gradient bg-tempting-azure">
					</i> Bandwidth Reports
				</div>
				<div class="btn-actions-pane-right">
					<div class="nav">
						<a href="javascript:void(0);"
							class="border-0 btn-pill btn-wide btn-transition active btn btn-outline-alternate">Tab
							1</a> <a href="javascript:void(0);"
							class="ml-1 btn-pill btn-wide border-0 btn-transition  btn btn-outline-alternate second-tab-toggle-alt">Tab
							2</a>
					</div>
				</div>
			</div>
			<div class="tab-content">
				<div class="tab-pane fade active show" id="tab-eg-55">
					<div class="widget-chart p-3">
						<div style="height: 350px">
							<canvas id="line-chart"></canvas>
						</div>
						<div class="widget-chart-content text-center mt-5">
							<div class="widget-description mt-0 text-warning">
								<i class="fa fa-arrow-left"></i> <span class="pl-1">175.5%</span>
								<span class="text-muted opacity-8 pl-1">increased server
									resources</span>
							</div>
						</div>
					</div>
					<div class="pt-2 card-body">
						<div class="row">
							<div class="col-md-6">
								<div class="widget-content">
									<div class="widget-content-outer">
										<div class="widget-content-wrapper">
											<div class="widget-content-left">
												<div class="widget-numbers fsize-3 text-muted">63%</div>
											</div>
											<div class="widget-content-right">
												<div class="text-muted opacity-6">Generated Leads</div>
											</div>
										</div>
										<div class="widget-progress-wrapper mt-1">
											<div
												class="progress-bar-sm progress-bar-animated-alt progress">
												<div class="progress-bar bg-danger" role="progressbar"
													aria-valuenow="63" aria-valuemin="0" aria-valuemax="100"
													style="width: 63%;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="widget-content">
									<div class="widget-content-outer">
										<div class="widget-content-wrapper">
											<div class="widget-content-left">
												<div class="widget-numbers fsize-3 text-muted">32%</div>
											</div>
											<div class="widget-content-right">
												<div class="text-muted opacity-6">Submitted Tickers</div>
											</div>
										</div>
										<div class="widget-progress-wrapper mt-1">
											<div
												class="progress-bar-sm progress-bar-animated-alt progress">
												<div class="progress-bar bg-success" role="progressbar"
													aria-valuenow="32" aria-valuemin="0" aria-valuemax="100"
													style="width: 32%;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="widget-content">
									<div class="widget-content-outer">
										<div class="widget-content-wrapper">
											<div class="widget-content-left">
												<div class="widget-numbers fsize-3 text-muted">71%</div>
											</div>
											<div class="widget-content-right">
												<div class="text-muted opacity-6">Server Allocation</div>
											</div>
										</div>
										<div class="widget-progress-wrapper mt-1">
											<div
												class="progress-bar-sm progress-bar-animated-alt progress">
												<div class="progress-bar bg-primary" role="progressbar"
													aria-valuenow="71" aria-valuemin="0" aria-valuemax="100"
													style="width: 71%;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="widget-content">
									<div class="widget-content-outer">
										<div class="widget-content-wrapper">
											<div class="widget-content-left">
												<div class="widget-numbers fsize-3 text-muted">41%</div>
											</div>
											<div class="widget-content-right">
												<div class="text-muted opacity-6">Generated Leads</div>
											</div>
										</div>
										<div class="widget-progress-wrapper mt-1">
											<div
												class="progress-bar-sm progress-bar-animated-alt progress">
												<div class="progress-bar bg-warning" role="progressbar"
													aria-valuenow="41" aria-valuemin="0" aria-valuemax="100"
													style="width: 41%;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6 col-lg-3">
		<div
			class="card-shadow-danger mb-3 widget-chart widget-chart2 text-left card">
			<div class="widget-content">
				<div class="widget-content-outer">
					<div class="widget-content-wrapper">
						<div class="widget-content-left pr-2 fsize-1">
							<div class="widget-numbers mt-0 fsize-3 text-danger">71%</div>
						</div>
						<div class="widget-content-right w-100">
							<div class="progress-bar-xs progress">
								<div class="progress-bar bg-danger" role="progressbar"
									aria-valuenow="71" aria-valuemin="0" aria-valuemax="100"
									style="width: 71%;"></div>
							</div>
						</div>
					</div>
					<div class="widget-content-left fsize-1">
						<div class="text-muted opacity-6">Income Target</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6 col-lg-3">
		<div
			class="card-shadow-success mb-3 widget-chart widget-chart2 text-left card">
			<div class="widget-content">
				<div class="widget-content-outer">
					<div class="widget-content-wrapper">
						<div class="widget-content-left pr-2 fsize-1">
							<div class="widget-numbers mt-0 fsize-3 text-success">54%</div>
						</div>
						<div class="widget-content-right w-100">
							<div class="progress-bar-xs progress">
								<div class="progress-bar bg-success" role="progressbar"
									aria-valuenow="54" aria-valuemin="0" aria-valuemax="100"
									style="width: 54%;"></div>
							</div>
						</div>
					</div>
					<div class="widget-content-left fsize-1">
						<div class="text-muted opacity-6">Expenses Target</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6 col-lg-3">
		<div
			class="card-shadow-warning mb-3 widget-chart widget-chart2 text-left card">
			<div class="widget-content">
				<div class="widget-content-outer">
					<div class="widget-content-wrapper">
						<div class="widget-content-left pr-2 fsize-1">
							<div class="widget-numbers mt-0 fsize-3 text-warning">32%</div>
						</div>
						<div class="widget-content-right w-100">
							<div class="progress-bar-xs progress">
								<div class="progress-bar bg-warning" role="progressbar"
									aria-valuenow="32" aria-valuemin="0" aria-valuemax="100"
									style="width: 32%;"></div>
							</div>
						</div>
					</div>
					<div class="widget-content-left fsize-1">
						<div class="text-muted opacity-6">Spendings Target</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-6 col-lg-3">
		<div
			class="card-shadow-info mb-3 widget-chart widget-chart2 text-left card">
			<div class="widget-content">
				<div class="widget-content-outer">
					<div class="widget-content-wrapper">
						<div class="widget-content-left pr-2 fsize-1">
							<div class="widget-numbers mt-0 fsize-3 text-info">89%</div>
						</div>
						<div class="widget-content-right w-100">
							<div class="progress-bar-xs progress">
								<div class="progress-bar bg-info" role="progressbar"
									aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"
									style="width: 89%;"></div>
							</div>
						</div>
					</div>
					<div class="widget-content-left fsize-1">
						<div class="text-muted opacity-6">Totals Target</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


