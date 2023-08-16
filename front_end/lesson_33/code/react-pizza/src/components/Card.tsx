import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { selectCartItemById } from "../redux/slices/cartSlice";
import { setItem } from "../redux/slices/itemsSlice";
import { selectFilter } from "../redux/slices/filterSlice";
import { ReactComponent as StarIcon } from '../assets/images/star_icon.svg';
import { Link } from "react-router-dom";
import ParamsBlock from "./ParamsBlock";

type CardItem = {
    id: string;
    title: string;
    price: number;
    images: string[];
    sizes: number[];
    types: number[];
    rating: number;
    info: string[];
};

const Card: React.FC<CardItem> = ({
    id,
    title,
    price,
    images,
    sizes,
    types,
    rating,
    info
}) => {
    const counter = useSelector(selectCartItemById(id));
    const count: number = counter && counter.count;
    // const { activeSize, activeType } = useSelector(selectItemsData);
    const { categoryName } = useSelector(selectFilter);
    const isCategoryClose = categoryName === "Закрытые";

    const dispatch = useDispatch();

    const cardItem: CardItem = {
        id,
        title,
        price,
        images,
        sizes,
        types,
        rating,
        info
    };

    return (
        <article className={`card ${isCategoryClose ? 'card_disabled' : ''}`}>
            <div className="card__rating">
                <StarIcon className="card__rating-icon"/>
                <span className="card__rating-text">
                    {rating}
                </span>
            </div>
            <img src={images[0]} alt={title} className="card__image" />
            <h2>
                <Link
                    to={`/pizza/${id}`}
                    className="card__link"
                    onClick={() => dispatch(setItem(cardItem))}
                >
                    {title}
                </Link>
            </h2>
            <ParamsBlock className="card__params-block" types={types} sizes={sizes} />
            <div className="card__footer">
                <span className="card__price">от {price} &#8381;</span>
                <button>
                    <span className="card__button-icon">+</span>
                    Добавить
                    {/* {count ? <span className="card__button-counter">{count}</span> : <></>} */}
                    {count && <span className="card__button-counter">{count}</span>}
                </button>
            </div>
        </article>    
    );
};

export default Card;
