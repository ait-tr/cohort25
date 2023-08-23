import { NavLink } from "react-router-dom";
import styles from './NavBar.module.css';


export default function NavBar():JSX.Element{
    return (
        <nav className={styles.container}>
            <NavLink className={styles.link} to="counter">Counter</NavLink>
            <NavLink className={styles.link} to="pizza">Pizza</NavLink>
            <NavLink className={styles.link} to="apple">Apple</NavLink>
        </nav>
    );
}