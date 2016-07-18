$(".answerWrite input[type=submit]").click(addAnswer);//답변하기 버튼을 찾음

function addAnswer(e){

	e.preventDefault(); //submit 이 자동으로 동작하는 것을 막는다.
	var queryString = $("form[name=answer]").serialize(); //form data들을 자동으로 묶어준다.
	console.log(queryString);
	$.ajax({
		type : 'post',
		url :'/api/qna/addanswer',
		data : queryString,
		dataType : 'json',
		error: onError,
		success : onSuccess
	});
}
function onError(xhr, status) {
	 alert("error");
	} 

function onSuccess(json, status){
	console.log(json);
	var answerTemplate = $("#answerTemplate").html();
	 var template = answerTemplate.format(json.writer, new Date(json.createdDate), json.contents, json.answerId, json
	.answerId);
	 $(".qna-comment-slipp-articles").prepend(template);
} 

String.prototype.format = function() {

	var args = arguments;
	return this.replace(/{(\d+)}/g, function(match, number) {
		return typeof args[number] != 'undefined'
			? args[number]
		: match
		;
	});
};

