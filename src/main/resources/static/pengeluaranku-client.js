$(document).ready(function() {


    $("#tambah-pengeluaran").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
        var $form = $( this ),
            namaPengeluaran = $form.find( "input[name='nama-pengeluaran']" ).val(),
            kodePengeluaran = $form.find( "input[name='kode-pengeluaran']" ).val(),
            tipePengeluaran = $form.find( "input[name='tipe-pengeluaran']" ).val();

        // Compose the data in the format that the API is expecting
        var data = { name: namaPengeluaran, code: kodePengeluaran, type: tipePengeluaran};

        // Send the data using post
        $.ajax({
            url: 'http://http://localhost:41099/pengeluaranku-service/api/v1/pengeluaran/add',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(result){
                if(result.correct) {
                    $('.result-message').empty().append("Selamat! Pengeluaranmu Berhasil Terdaftar");
                } else {
                    $('.result-message').empty().append("Yah Pengeluaran Gagal Didaftarkan");
                }
            }
        });

    });
});
