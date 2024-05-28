//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

export default function Login(){

    const verificarConta = async () => {
        var nconta = document.getElementById("campoConta").value;
        var senha = document.getElementById("campoSenha").value;
        fetch(
            "http://127.0.0.1:8080/api/conta/" + nconta,
          )
            .then((r) => r.json())
            .then((f) => {
              if(f.senha == senha){
                document.cookie = "sessao=" + nconta;
                alert("Login realizado com sucesso")
              }else{
                alert("Senha ou Login Incorreto")
              }
            });

      }
    return(
        <main class="form-signin w-100 m-auto">
      <img class="mb-4" src="cyberbank.png" alt="" width="72" height="57"></img>
      <h1 class="h3 mb-3 fw-normal">Formulario de Login</h1>

      <div class="form-floating">
        <input type="text" class="form-control" id="campoConta" placeholder="name@example.com"></input>
        <label for="floatingInput">Numero da Conta</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="campoSenha" placeholder="Password"></input>
        <label for="floatingPassword">Senha</label>
      </div>

      <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault"></input>
        <label class="form-check-label" for="flexCheckDefault">
          Lembrar
        </label>
      </div>
      <button class="btn btn-primary w-100 py-2"  onClick={verificarConta}>Login</button>
    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    </main>
    );
}