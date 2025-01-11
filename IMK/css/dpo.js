// Fungsi untuk menambahkan event listener pada form login dan register
document.getElementById('login-form').addEventListener('submit', function(event) {
  event.preventDefault();
  // Ambil data inputan
  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;
  
  if (email && password) {
      alert('Login Berhasil');
      // Redirect atau proses login lainnya
      window.location.href = 'home.html';
  } else {
      alert('Harap isi semua kolom');
  }
});

document.getElementById('register-form').addEventListener('submit', function(event) {
  event.preventDefault();
  // Ambil data inputan
  let username = document.getElementById('username').value;
  let email = document.getElementById('email').value;
  let phone = document.getElementById('phone').value;
  
  if (username && email && phone) {
      alert('Pendaftaran Berhasil');
      // Redirect atau proses registrasi lainnya
      window.location.href = 'login.html';
  } else {
      alert('Harap isi semua kolom');
  }
});
