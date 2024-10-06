import React, { useState } from 'react';
import { Button, Card, Col, Container, Form, Row } from 'react-bootstrap';

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        // Xử lý logic đăng nhập
        console.log("Email:", email);
        console.log("Password:", password);
    };

    return (
        <Container className="d-flex align-items-center justify-content-center" style={{ minHeight: "81vh" }}>
            <Row className="w-100 justify-content-center">
                <Col xs={12} md={6} lg={4}>
                    <Card className="shadow">
                        <Card.Body>
                            <h2 className="text-center mb-4">Đăng Nhập</h2>
                            <Form onSubmit={handleSubmit}>
                                <Form.Group id="email" className="mb-3">
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control
                                        type="email"
                                        required
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                    />
                                </Form.Group>
                                <Form.Group id="password" className="mb-3">
                                    <Form.Label>Mật Khẩu</Form.Label>
                                    <Form.Control
                                        type="password"
                                        required
                                        value={password}
                                        onChange={(e) => setPassword(e.target.value)}
                                    />
                                </Form.Group>
                                <Button className="w-100" type="submit">Đăng Nhập</Button>
                            </Form>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
        // <>
        //     <div>Đăng nhập</div>
        //     <Form>
        //         <Form.Group className="mb-3" controlId="email">
        //             <Form.Label>Email</Form.Label>
        //             <Form.Control type="email" />
        //         </Form.Group>
        //         <Form.Group className="mb-3" controlId="password">
        //             <Form.Label>Mật khẩu</Form.Label>
        //             <Form.Control type="password" />
        //         </Form.Group>
        //     </Form>
        //     <Button className='text-center my-3' variant="dark">Đăng nhập</Button>
        // </>
    
};

export default Login;