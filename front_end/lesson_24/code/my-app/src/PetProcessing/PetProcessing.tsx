import PetRecord, {Pet} from "../PetRecord/PetRecord";

export default function PetProcessing():JSX.Element{

    const pet1:Pet={
        id:1,
        petName:'name1',
        additionalInfo:'additional info about pet #1',
        dysplayInfo: true,
    }

    const pet2:Pet={
        id:2,
        petName:'name2',
        additionalInfo:'additional info about pet #2',
        dysplayInfo: false,
        color: 'red',
    }

    const pet3:Pet={
        id:3,
        petName:'name3',
        additionalInfo:'additional info about pet #3',
        dysplayInfo: true,
    }
    
    return(
        <>
            <PetRecord pet={pet1} ></PetRecord>
            <PetRecord pet={pet2} ></PetRecord>
            <PetRecord pet={pet3} ></PetRecord>
        </>
    );
}