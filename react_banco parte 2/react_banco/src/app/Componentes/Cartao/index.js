//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

export default function Cartao(props){
    
    const deletarCartao = async () => { 
    
        fetch("http://127.0.0.1:3000/api/cartao/" + props.num, {
           method: "DELETE",
           headers: {
            'Content-type': 'application/json',
           },
          })
          .then((resp) => resp.json())
          .then((d) => {
            console.log(d);
            getTarefas();
          })
    }
    
    return(
        <div class="cartao" >
            <section class="card credito">
                <div id="borda">
                    <div class="titulo">
                        <p>CyberCard - <strong>Crédito</strong></p>
                        <img id="logo" src="itau.png" alt="Itau Logo"></img>
                    </div>
                    <section class="dados">
                        <img id="chip" src="chip.svg" alt="Chip"></img>
                        <div class="card_number">
                            <p>{props.num}</p>
                            <p>{props.num}</p>
                            <p>{props.num}</p>
                            <p>{props.num}</p>
                        </div>
                        <section class="card_bloco_final">
                                <p class="card_labels"><strong>PIN: </strong>{props.senha}</p>
                                <div class="card_dates">
                                    <p>Valid Date</p>
                                    <p>{props.validade}</p>
                                </div>
                                <img id="mastercard" src="mastercard.svg" alt="Mastercard Logo"></img>
                        </section>
                    </section>
                </div>
            </section>
            <button class="exclui" onClick={deletarCartao}>Cancelar Cartão</button>
        </div>
    );
}