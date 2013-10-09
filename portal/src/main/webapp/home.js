 $(document).ready(function () {
    
	 
	 
	 $("a#logout").click(function(e){
		 window.location.href="/Logout";
	 });
	 
	 $.ajax({
         type: "POST",
         url: 'UserDetails',
         data: { 'user': USER},
         dataType: "json",
         success: function (data) {
        	 var tblData = "";
             if (data && data['status']==='ok' && data['data']!=='' ) {
            	 for(var i=0;i<data['data'].length;i++){
                     var currRow = data['data'][i], row = [];
                     row.push('<tr data-name=\"' + currRow['name'] +'\" data-id=\"' + currRow['id'] + '\"><td>' + currRow['id'] + '</td><td>' + currRow['name'] + '</td></tr>');
                     tblData += row.join('');
                 }
             }
             //unbind all events
             $( "table.grid tr").unbind( "click" );
             $('table.grid').find('tbody').empty();
             $('table.grid tbody').append(tblData);
             $('table.grid').delegate("tr", "click", function(e) {
                 e.preventDefault();
                 e.stopImmediatePropagation();
                 var id = $(this).data('id'),
                 	name = $(this).data('name');
                 $("input#name").val(name);
                 $("div.edit").show();
             });
         }
     });
	 
	 $("input#update").click(function(){
		 //todo
	     $("div.edit").hide();
	 });
	 
});