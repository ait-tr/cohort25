import { Outlet } from "react-router-dom";
import NavBar from "../NavBar/NavBar";

export default function Layout():JSX.Element{
    return (
        <>
            <header>
                <h1>My site</h1>
                <NavBar />
            </header>
            
            <div>
                < Outlet  />
            </div>

            <footer>
                <p> Footer </p>
            </footer>
        </>
    )
}