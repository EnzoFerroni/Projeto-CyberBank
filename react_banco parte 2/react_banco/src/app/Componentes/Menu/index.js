import "./style.css";
import Link from "next/link";

//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

export default function Menu(){
    return(
        <header class="navegacao">
                <nav>
                    <section class="navegacao_pags_bloco1">
                        <div class="navegacao_logo">
                            <img id="navegacao_logo_img" src="cyberbank.png" alt="Logo do Cyberbank"></img>
                            <h5 id="navegacao_logo_slogan">CyberBank</h5>
                        </div>
                        <ul></ul>
                            <li class="lista_nav"><Link class="nav_link" href="/">Home</Link></li>
                            <li class="lista_nav"><Link class="nav_link" href="Conta">Minha Conta</Link></li>
                            <li class="lista_nav"><Link class="nav_link" href="Cartoes">Meus Cartões</Link></li>
                            <li class="lista_nav"><Link class="nav_link" href="Transacoes">Transações</Link></li>
                    </section>
                </nav>
            </header>

    );
}