import { Route, Routes } from "react-router-dom";
import Layout from "../Layout/Layout";
import Counter from "../Counter/Counter";
import Pizza from "../Pizza/Pizza";
import Apple from "../Apple/Apple";

export default function MyApp():JSX.Element {
    return(
        <Routes>
            <Route path="/" element = {<Layout />}  >
                <Route path="counter" element ={<Counter />} />     
                <Route path="pizza" element ={<Pizza />} />     
                <Route path="apple" element ={<Apple />} />     
            </Route>
        </Routes>
    )
}