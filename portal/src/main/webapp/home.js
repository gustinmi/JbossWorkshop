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
                     row.push('<tr><td>' + currRow['id'] + '</td><td>' + currRow['name'] + '</td></tr>');
                     tblData += row.join('');
                 }
             }
             $('table.grid').find('tbody').empty();
             $('table.grid tbody').append(tblData);
         }
     });
	 
});