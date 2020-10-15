var product = {
    init : function () {
        var _this = this;

        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-save').on('click', function () {
        	_this.save();
        });
        $('#btn-delete').on('click', function () {
        	_this.remove();
        });
        $('#btn-delete-all').on('click', function () {
        	_this.remove('all');
        });
    },
    validate : function(){
        var form = $("#myForm")

        if (form[0].checkValidity() === false) {
        	  form.addClass('was-validated');
        	  return false;
        }
        return true;
      
        
    },
    update : function () {
    	 var _this = this;
    	if(!_this.validate()){
    		return false;
    	}
        var data = {
        	categoryNo: $('#categoryNo').val(),
    		categoryName: $('#categoryName').val()
        };
        $.ajax({
            type: 'POST',
            url: '/category/update',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('카테고리 정보를 수정하였습니다');
            location.reload();
        }).fail(function (error) {
        	alert('카테고리 정보 수정중 문제가 발생하였습니다');
        });
    },
    save : function () {
	   	 var _this = this;
	 	if(!_this.validate()){
	 		return false;
	 	}
    	var data = {
            	categoryNo: $('#categoryNo').val(),
    			categoryName: $('#categoryName').val(),
    			depth :$('#depth').val(),
    			parentNo: $('#parentNo').val()
    	};
    	$.ajax({
    		type: 'POST',
    		url: '/category/insert',
    		dataType: 'json',
    		contentType:'application/json; charset=utf-8',
    		data: JSON.stringify(data)
    	}).done(function() {
    		alert('카테고리 정보를 등록 하였습니다');
            location.reload();
    	}).fail(function (error) {
    		alert('카테고리 정보 등록중 문제가 발생하였습니다');
    	});
    },
    remove : function (type) {
    	var data = {
    			categoryNo :(type!=='all')?$('#categoryNo').val():null

    	};
    	$.ajax({
    		type: 'POST',
    		url: '/category/delete',
    		dataType: 'json',
    		contentType:'application/json; charset=utf-8',
    		data: JSON.stringify(data)
    	}).done(function() {
    		alert('카테고리 정보를 삭제 하였습니다');
    	}).fail(function (error) {
    		alert('카테고리 정보 삭제중 문제가 발생하였습니다');
    	});
    }

};

product.init();
