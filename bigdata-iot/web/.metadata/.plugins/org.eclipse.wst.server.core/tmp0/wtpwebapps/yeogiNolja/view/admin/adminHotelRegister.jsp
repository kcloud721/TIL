<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="app-page-title">
	<div class="page-title-wrapper">
		<div class="page-title-heading">
			<div class="page-title-icon">
				<i class="pe-7s-glasses icon-gradient bg-love-kiss"> </i>
			</div>
			<div>
				Register HOTEL & ROOM
				<div class="page-title-subheading">Notifications represent one
					of the best ways to give feedback for various users actions.</div>
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
				<div tabindex="-1" role="menu" aria-hidden="true"
					class="dropdown-menu dropdown-menu-right">
					<ul class="nav flex-column">
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-inbox"></i> <span>
									Inbox </span>
								<div class="ml-auto badge badge-pill badge-secondary">86</div>
						</a></li>
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-book"></i> <span>
									Book </span>
								<div class="ml-auto badge badge-pill badge-danger">5</div>
						</a></li>
						<li class="nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon lnr-picture"></i> <span>
									Picture </span>
						</a></li>
						<li class="nav-item"><a disabled href="javascript:void(0);"
							class="nav-link disabled"> <i
								class="nav-link-icon lnr-file-empty"></i> <span> File
									Disabled </span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="${message}"></jsp:include>

<ul
	class="body-tabs body-tabs-layout tabs-animated body-tabs-animated nav">
	<li class="nav-item"><a role="tab" class="nav-link active"
		id="tab-0" data-toggle="tab" href="#tab-content-0"> <span>HOTEL</span>
	</a></li>
	<li class="nav-item"><a role="tab" class="nav-link" id="tab-2"
		data-toggle="tab" href="#tab-content-2"> <span>ROOM</span>
	</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane tabs-animation fade show active"
		id="tab-content-0" role="tabpanel">
		<form action="adminHotelRegisterImpl.mc" method="post">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Enter Hotel Information</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="form-label" for="title"><h5>Hotel ID</h5></label> <input
								id="title" name="hotel_id" type="text" class="form-control"
								value="ht1001"/>
						</div>
						<div class="form-group">
							<label class="form-label" for="message"><h5>NAME</h5></label> <input
								id="title" name="name" type="text" class="form-control"
								value="Park Hyatt" />
						</div>
					</div>
					
					<div class="col-md-3">
						<h5>Address</h5>
						<div class="form-group">
							<label for="showEasing">City</label> <input
								id="showEasing" name="addr_sd" type="text" placeholder="swing, linear"
								class="form-control" value="서울특별시" />
						</div>
						<div class="form-group">
							<label for="hideEasing">Address 1</label> <input
								id="hideEasing" name="addr_sgg" type="text" placeholder="swing, linear"
								class="form-control" value="강남구" />
						</div>
						<div class="form-group">
							<label for="showMethod">Address 2</label> <input
								id="showMethod" name="addr_emd" type="text"
								placeholder="show, fadeIn, slideDown" class="form-control"
								value="테헤란로 606" />
						</div>
						<h5>Number of Rooms</h5>
						<div class="form-group">
							<input id="showDuration" type="number" name="total_room" placeholder="ms"
								class="form-control" value="120" />
						</div>
					</div>

					<div class="col-md-3">
						<div id="positionGroup">
							<h5>Amenities</h5>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox1" name="amenities" class="custom-control-input"
									value="실내수영장" checked /> <label class="custom-control-label" 
									for="exampleCustomCheckbox1"> 실내수영장 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox2" name="amenities" class="custom-control-input"
									value="레스토랑" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox2"> 레스토랑 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox3" name="amenities" class="custom-control-input"
									value="회의실" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox3"> 회의실 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox4" name="amenities" class="custom-control-input"
									value="운동시설" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox4"> 운동시설 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox5" name="amenities" class="custom-control-input"
									value="무료와이파이" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox5"> 무료 와이파이 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox6" name="amenities" class="custom-control-input"
									value="주차장" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox6"> 주차장 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox7" name="amenities" class="custom-control-input"
									value="반려동물동반" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox7"> 반려동물 동반 </label>
							</div>
							<div class="custom-checkbox custom-control">
								<input type="checkbox" id="exampleCustomCheckbox8" name="amenities" class="custom-control-input"
									value="카페" /> <label class="custom-control-label" 
									for="exampleCustomCheckbox8"> 카페 </label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div id="toastTypeGroup">
							<h5>Grade</h5>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio1" class="custom-control-input"
									name="grade" value="1급" checked /> <label class="custom-control-label"
									for="exampleCustomRadio1"> 1급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio2" class="custom-control-input"
									name="grade" value="2급" /> <label class="custom-control-label"
									for="exampleCustomRadio2"> 2급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio3" class="custom-control-input"
									name="grade" value="3급" /> <label class="custom-control-label"
									for="exampleCustomRadio3"> 3급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio4" class="custom-control-input"
									name="grade" value="4급" /> <label class="custom-control-label"
									for="exampleCustomRadio4"> 4급 </label>
							</div>
							<div class="custom-radio custom-control">
								<input type="radio" id="exampleCustomRadio5" class="custom-control-input"
									name="grade" value="5급" /> <label class="custom-control-label"
									for="exampleCustomRadio5"> 5급 </label>
							</div>				
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="btn btn-success">Register </button>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	
	<div class="tab-pane tabs-animation fade" id="tab-content-2"
		role="tabpanel">
		<form action="adminHotelRoomRegisterImpl.mc" method="post">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<div class="card-title">Enter Room Information</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="form-label" for="title"><h5>Room ID</h5></label> <input
								id="title" name="room_id" type="text" class="form-control"
								value="rm1001"/>
						</div>
						<div class="form-group">
							<label class="form-label" for="message"><h5>Room Name</h5></label> <input
								id="title" name="room_name" type="text" class="form-control"
								value="디럭스 킹" />
						</div>
						<div class="form-group">
							<label class="form-label" for="message"><h5>Room Number</h5></label> <input
								id="title" name="room_num" type="text" class="form-control"
								value="1101" />
						</div>						
					</div>
					<div class="col-md-3">					
						<div class="form-group">
							<label class="form-label" for="message"><h5>Hotel ID</h5></label> <input
								id="title" name="hotel_id" type="text" class="form-control"
								value="ht0001" />
						</div>
					</div>
					<div class="col-md-3">
						<h5>Adults</h5>
						<div class="form-group">
							<input id="showDuration" type="number" name="adults" placeholder="ms"
								class="form-control" value="3" />
						</div>
						
						<h5>PRICE</h5>
						<div class="form-group">
							<input id="showDuration" type="number" name="price" placeholder="ms"
								class="form-control" value="50000" />
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer d-block clearfix">
				<div class="float-right">
					<button type="submit" class="btn btn-success">Register </button>
				</div>
			</div>
		</div>
		</form>
	</div>
</div>

