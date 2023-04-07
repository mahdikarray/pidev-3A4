<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Fournisseur
 *
 * @ORM\Table(name="fournisseur")
 * @ORM\Entity
 */
class Fournisseur
{
    /**
     * @var int
     *
     * @ORM\Column(name="idf", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idf;

    /**
     * @var string
     *
     * @ORM\Column(name="nomf", type="string", length=20, nullable=false)
     */
    private $nomf;

    /**
     * @var string
     *
     * @ORM\Column(name="regionf", type="string", length=20, nullable=false)
     */
    private $regionf;


}
