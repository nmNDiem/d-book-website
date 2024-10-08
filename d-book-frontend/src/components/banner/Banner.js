import React from 'react';
import { Carousel } from 'react-bootstrap';

const Banner = () => {
    return (
        <Carousel data-bs-theme="dark" className='h-25'>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/2828082/pexels-photo-2828082.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                    alt="First slide"
                    style={{ height: '300px', objectFit: 'cover' }}
                />
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/1005012/pexels-photo-1005012.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                    alt="Second slide"
                    style={{ height: '300px', objectFit: 'cover' }}
                />
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/612997/pexels-photo-612997.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                    alt="Third slide"
                    style={{ height: '300px', objectFit: 'cover' }}
                />
            </Carousel.Item>
        </Carousel>
    );
};

export default Banner;