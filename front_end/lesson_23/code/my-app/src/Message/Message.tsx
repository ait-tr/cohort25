import { title } from "process";

type Props={msg:string; title:string};


export default function Message(p:Props):JSX.Element {
const{msg,title} =p;

    let res:string;
    
    if(p.title=='hello'){
        res="";
    } else {
        res= p.title + " " + p.msg + msg;
    }
    return (
        <>
            <h1>{res}</h1>
        </>    
    );
}
//export default Message;