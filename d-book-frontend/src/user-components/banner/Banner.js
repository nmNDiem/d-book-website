import React, { useEffect, useState } from 'react';
import { Carousel } from 'react-bootstrap';
import APIs, { endpoints } from '../../configs/APIs';
import MySpinner from '../commons/MySpinner';

const Banner = () => {
    const [banners, setBanners] = useState([]);

    useEffect(() => {
        const loadBanners = async () => {
            try {
                let res = await APIs.get(endpoints['banners']);
                setBanners(res.data);
            } catch (err) {
                console.error(err);
            }
        };

        loadBanners();
    }, []);

    return (
        <Carousel data-bs-theme="dark" className='h-25'>
            {banners === null || banners.length === 0 ?
                <Carousel.Item style={{ height: '350px', objectFit: 'cover' }}>
                    <MySpinner />
                </Carousel.Item>
                : banners.map((banner) => (
                    <Carousel.Item>
                        <img
                            className="d-block w-100"
                            src={banner.image}
                            alt="First slide"
                            style={{ height: '350px', objectFit: 'cover' }}
                        />
                    </Carousel.Item>
                ))
            }
        </Carousel>
    );
};

export default Banner;