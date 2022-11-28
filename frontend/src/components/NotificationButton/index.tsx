import axios from 'axios';
import icon from '../../assets/img/notification_icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css'

/*props - como se fossem parâmetros que um 
componente do react pode receber*/ 
type Props = {
  saleId: number;
}

/*função que faz a chamada da api, chama o endpoint que manda o sms*/
function handleClick(id: number){
  axios(`${BASE_URL}/sales/${id}/notification`)
  .then(response => {
    console.log("SUCESSO");
  })
}

function NotificationButton( {saleId} : Props ) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
        <img src={icon} alt="Notificar" />
      </div>
    )
  }
  
  export default NotificationButton;
  