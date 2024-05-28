export default function Transacao(props){
    return(
            <tr>
                <td>{props.id}</td>
                <td>{props.data}</td>
                <td>R$ {props.valor}</td>
                <td>{props.origem}</td>
                <td>{props.destino}</td>
            </tr>


    );
}